package cn.duchaoqun.Chapter12

object Demo12_8 extends App {
  // 指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程，新的函数返回一个以原有第二个参数作为参数的函数。

  // 定义一个接受两个参数的函数
  def mul(x: Int, y: Int) = x * y

  // 下面函数接收一个参数，返回一个函数，返回的这个函数接受另外一个参数。
  def mulOneAtATime(x: Int) = (y: Int) => x * y

  // 要计算两个数的乘积，使用如下调用方式。
  println(mulOneAtATime(3)(4))



  val a = Array("Hello", "Scala")
  val b = Array("hello", "scala")
  // todo: 书中的这里还不是很理解
  a.corresponds(b)(_.equalsIgnoreCase(_))
}
