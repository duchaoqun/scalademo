package cn.duchaoqun.DemoSpider

import java.sql.{Connection, DriverManager, ResultSet}

import cn.duchaoqun.util.{JDBC, Security}
import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.{BrowserVersion, NicelyResynchronizingAjaxController, WebClient}
import org.jsoup.Jsoup

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

/**
  * 获取练习数据
  */
object DemoSpider{

  // 创建模拟谷歌浏览器对象
  val webClient = new WebClient(BrowserVersion.CHROME)

  // 禁止 CSS
  webClient.getOptions.setCssEnabled(false)

  // 启动 JS 解释器，默认为 true
  webClient.getOptions.setJavaScriptEnabled(true)

  // 设置支持AJAX
  webClient.setAjaxController(new NicelyResynchronizingAjaxController)

  // JS 执行出错的时候禁止抛出异常
  webClient.getOptions.setThrowExceptionOnScriptError(false)

  // Response 为非200 的时候禁止抛出异常
  webClient.getOptions.setThrowExceptionOnFailingStatusCode(false)

  // 设置连接超时时间
  webClient.getOptions.setTimeout(10 * 1000)

  // 等待JS执行: 这里等待 10 秒
  webClient.waitForBackgroundJavaScript(10)

  // 准备 JDBC 连接
  val conn = JDBC.getPGConn


  /**
    * 从数据库中获取随机的页面开始抓取
    * @param conn 数据库连接
    * @return
    */
  def getRandomHtml(conn: Connection): String = {
    val sql = "select html from t_01 order by random() LIMIT 1"
    //val prep = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val prep = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)
    val rs = prep.executeQuery(sql)
    var resultSet = ""
    while (rs.next()){
      resultSet = rs.getString("html")
    }
    resultSet
  }

  /**
    * 获取网页信息
    * @param urlStr 准备获取的 URL 地址字符串
    * @return
    */
  def getHtmlPage(urlStr: String): HtmlPage ={
    val htmlPage: HtmlPage = webClient.getPage(urlStr)
    htmlPage
  }


  /**
    * 获取源代码中的 Title 中的文本
    * @param urlHtml HTMl 源代码
    * @return
    */
  def getUrlTitle(urlHtml: String): String ={
    // 根据 Tag 名称获取 Tag 中包含的文本
    val title = Jsoup.parse(urlHtml).getElementsByTag("title").text()
    title
  }


  /**
    * 从一个 html 源代码页面提取所有的超链接
    * @param urlHtml html 源代码
    * @return
    */
  def getUrlList(urlHtml:String): collection.mutable.Set[String] = {
    val resultSet: collection.mutable.Set[String] = collection.mutable.Set()
    val elementsA = Jsoup.parse(urlHtml).getElementsByTag("a").asScala
    elementsA.foreach(tagA => {
      val href = tagA.attr("abs:href")
      if (href.length>7){
        resultSet.add(href)
      }
    })
    resultSet
  }


  /**
    * 将网页数据插入到数据库
    * @param strMD5 URL 的 Hash
    * @param urlStr URL 信息
    * @param html   URL 的 html 源代码
    */
  def insertData(strMD5:String ,urlTitle:String ,urlStr:String, html:String): Unit ={
    val sql = "insert into t_01(md5, title, url, html) values(?, ?, ?, ?)"
    val ps = conn.prepareStatement(sql)
    ps.setString(1, strMD5)
    ps.setString(2, urlTitle)
    ps.setString(3, urlStr)
    ps.setString(4, html)
    ps.executeUpdate()
  }


  /**
    * 检测目标 URL 是否已经存在数据库中
    * @param urlHash 目标 Url 的 Hash 值
    * @return
    */
  def targetIsExist(urlHash:String):Boolean = {
    val sql = "select md5 from t_01 where md5 = ?"
    val ps = conn.prepareStatement(sql)
    ps.setString(1, urlHash)
    ps.executeQuery().next()
  }


//  val rootURL = "http://www.duwenzhang.com/"
//  val urlHash = Security.computeStringMD5Hash(rootURL)
//  val urlPage: HtmlPage = webClient.getPage(rootURL)
//  val urlHtml = urlPage.asXml()
//  val urlTitle = getUrlTitle(urlHtml)
//  insertData(urlHash, urlTitle, rootURL, urlHtml)


  def main(args: Array[String]): Unit = {
    while (true){
      val urlPage = getRandomHtml(conn)
      val targetSet = getUrlList(urlPage)

      targetSet.foreach(targetUrl => {
        if(targetIsExist(targetUrl)){
          println("Target is exist!")
        } else {
          val urlHash = Security.computeStringMD5Hash(targetUrl)
          val urlPage: HtmlPage = webClient.getPage(targetUrl)
          val urlHtml = urlPage.asXml()
          val urlTitle = getUrlTitle(urlHtml)
          insertData(urlHash,urlTitle,targetUrl,urlHtml)
        }
      })
    }
    conn.close()
  }
}


