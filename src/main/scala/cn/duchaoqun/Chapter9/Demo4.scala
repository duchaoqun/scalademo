package cn.duchaoqun.Chapter9

/**
  * 9.4 从URL或者其他来源读取数据
  */
object Demo4 extends App {
  // 从URL读取时，我们需要先知道网页的字符集，可能是通过HTTP头获取。
  val source1 = scala.io.Source.fromURL("https://www.duchaoqun.cn", "UTF-8")

  // 从给定的字符集获取数据，对调试有帮助。
  val source2 = scala.io.Source.fromString("1. The first line!")

  // 从标准输入读取。
  val source3 = scala.io.Source.stdin
}
