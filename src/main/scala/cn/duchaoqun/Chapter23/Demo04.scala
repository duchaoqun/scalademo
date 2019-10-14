package cn.duchaoqun.Chapter23

/**
  * Try 不能完全替代 Either，它只是 Either 用来处理异常的一个特殊用法，Try 和 Either 互相补充，各自侧重于不同的使用场景。
  * 使用 Either 的时候不需要引用任何其他的包，默认就会被引入 scala.util.Either
  * 引用：http://wiki.jikexueyuan.com/project/guides-to-scala-book/chp7-the-either-type.html
  */
object Demo04 extends App {
  def f(i: Int) = {
    if (i == 0) Left("Divide by zero") else Right(24 / i)  // Left just bring you a message, it can be Error message , or other information.
  }

  def test(n: Int) = f(n) match {
    case Left(why) => s"Failed:$why"
    case Right(result) => result
  }

  for (x <- 0 to 20) {
    println(test(x))
  }
}
