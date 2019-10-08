package cn.duchaoqun.Chapter12

object Demo13 extends App {
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

  /**
    * 案例D 返回值也可以是函数, currying
    * 1. 当函数的返回类型是函数的时候, 这个时候就表明,scala 的函数实现了闭包!
    * scala闭包的内幕是: scala的函数背后是类和对象, 所以scala的参数都作为了对象的成员, 所有后续可以继续访问, 这就是scala实现闭包原理的内幕.
    * 2. Currying, 复杂的函数式编程中经常使用, 可以维护变量在内存中的状态, 且实现返回函数的链式功能, 可以实现非常复杂的算法和逻辑.
    */
  def funcResultA = (name: String) => println("Hi, " + name)

  funcResultA("Spark")

  def funcResultB(message: String) = (name: String) => println(message + " Hi, " + name)

  funcResultB("BigData")("Spark") // 写法1 currying 柯里化函数写法, 必须掌握的写法, 实现复杂函数必备.

  val result = funcResultB("BigDate") // 写法2
  result("Spark")
}
