package info.aoye.Demo.io.Source

import scala.io.Source

object FromURL extends App {
  // 获取网页内容
  val html = Source.fromURL("https://www.baidu.com/") // 返回BufferedSource

}
