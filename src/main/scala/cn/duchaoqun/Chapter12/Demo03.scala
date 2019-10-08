package cn.duchaoqun.Chapter12

object Demo03 extends App {
  // 没有参数的函数。
  def f0: String = {
    scala.sys.props("java.version")
  }
  println(f0)
}
