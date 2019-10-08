package cn.duchaoqun.Chapter12

object Demo04 extends App {
  // 默认参数
  def decorate(str: String, left: String = "[", right: String = "]"): String = {
    left + str + right
  }

  // 在调用的时候如果不显式的提供参数，就使用默认的参数。
  println(decorate("Scala"))

  // 在调用的时候根据名字提供默认参数。
  println(decorate(str = "Scala", left = "《", right = "》"))
}
