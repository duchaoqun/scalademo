package cn.duchaoqun.DemoSpider

import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.{BrowserVersion, NicelyResynchronizingAjaxController, WebClient}
import com.typesafe.config.{Config, ConfigFactory}
import org.jsoup.Jsoup
import slick.jdbc.PostgresProfile.api._
import cn.duchaoqun.Model._
import com.typesafe.scalalogging.LazyLogging
import org.jsoup.select.Elements
import scala.concurrent.ExecutionContext.Implicits.global

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Demo extends App with LazyLogging {
  val webClient = new WebClient(BrowserVersion.CHROME)
  webClient.getOptions.setCssEnabled(false)        // CSS 开关
  webClient.getOptions.setJavaScriptEnabled(false) // JS 开关
  webClient.setAjaxController(new NicelyResynchronizingAjaxController)
  webClient.getOptions.setThrowExceptionOnScriptError(false)
  webClient.getOptions.setThrowExceptionOnFailingStatusCode(false)
  webClient.getOptions.setTimeout(10 * 1000)
  webClient.waitForBackgroundJavaScript(10)
  // 通过配置文件获取数据库连接
  val config: Config = ConfigFactory.parseURL(getClass.getResource("/application.properties"))
  val db = Database.forConfig("pg", config.getConfig("db"))


  def getUrlList:List[String] = {
    logger.info("getURLs")
    val baseURL = "https://www.jianshu.com/"
    val htmlPage: HtmlPage = webClient.getPage(baseURL)
    val html = htmlPage.asXml()
    // Elements: 根据 Attribute Value 来获取 Elements，然后再根据 class 来过滤我们需要的。
    val res = Jsoup.parse(html, baseURL).getElementsByAttributeValue("target", "_blank").select(".title")
    val array = new ArrayBuffer[String]
    res.forEach(x => {
      array += x.absUrl("href")
    })
    array.toList
  }

  def saveData(title: String, content: String): Unit = {
    val articleQuery = TableQuery[Article]
        //    val res1 = Await.result(db.run(articleQuery.filter(x => x.title === title).exists.result), Duration.Inf)
    val res1 = Await.result(db.run(articleQuery.filter(x => x.title === title).exists.result.flatMap(exist => {
      if (!exist) {
        logger.info("保存内容")
        articleQuery += ((0, title, content))
      } else {
        logger.info("内容已存在，跳过")
        DBIO.successful(None)
      }
    })), Duration.Inf)
  }

  def saveContent(UrlList: List[String]): Unit = {
    UrlList.foreach(x => {
      val htmlPage: HtmlPage = webClient.getPage(x)
      val title = Jsoup.parse(htmlPage.asXml()).getElementsByTag("title").text()
      val content = Jsoup.parse(htmlPage.asXml()).getElementsByTag("article").text()
      saveData(title, content)
    })
  }

  def getUrlList1(base: String):List[String] = {
    logger.info("getURLs")
    val baseURL = "https://www.jianshu.com/"
    val htmlPage: HtmlPage = webClient.getPage(baseURL)
    val html = htmlPage.asXml()
    // Elements: 根据 Attribute Value 来获取 Elements，然后再根据 class 来过滤我们需要的。
    val res = Jsoup.parse(html, baseURL).getElementsByAttributeValue("target", "_blank").select(".title")
    val array = new ArrayBuffer[String]
    res.forEach(x => {
      array += x.absUrl("href")
    })
    array.toList
  }
  getUrlList1("https://www.jianshu.com/p/c7647045d879").foreach(println)
  //saveContent(getUrlList)
  //db.close()

  // 创建表
  // Await.result(db.run(TableQuery[Article].schema.create),Duration.Inf)

}
