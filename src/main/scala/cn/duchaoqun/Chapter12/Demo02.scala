package cn.duchaoqun.Chapter12

object Demo02 extends App {
  // 斐波那契数列，简单的递归调用，注意这里需要定义结果类型。
  def fibonacci(n: Long): Long = {
    if (n < 1) 1
    else fibonacci(n - 2) + fibonacci(n - 1)
  }

  val result = fibonacci(30)
  println("Fibonacci is :" + result)
}
