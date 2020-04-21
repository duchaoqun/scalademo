package cn.duchaoqun.DemoSpider

import cn.duchaoqun.net.URL

import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.{BrowserVersion, NicelyResynchronizingAjaxController, WebClient}

object Demo extends App {
  val webClient = new WebClient(BrowserVersion.CHROME)
  webClient.getOptions.setCssEnabled(false)
  webClient.getOptions.setJavaScriptEnabled(true)
  webClient.setAjaxController(new NicelyResynchronizingAjaxController)
  webClient.getOptions.setThrowExceptionOnScriptError(false)
  webClient.getOptions.setThrowExceptionOnFailingStatusCode(false)
  webClient.getOptions.setTimeout(10 * 1000)
  webClient.waitForBackgroundJavaScript(10)

  val a: HtmlPage = webClient.getPage("http://www.duwenzhang.com/")

  val b = URL("http://www.duwenzhang.com/")


  println(b.getHost)
  //println(a.asXml())

}
