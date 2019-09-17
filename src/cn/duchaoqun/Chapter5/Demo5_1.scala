package cn.duchaoqun.Chapter5

/**
  * 5.1 简单类和无参方法
  */
object Demo5_1 extends App {
  //类并不声明为public，Scala源文件中可以包含多个Class，所有这些类都具有共有可见性。
  val myCounter = new Counter
  //调用无参方法可以省略小括号
  myCounter.increment()      // 对于改变对象状态的一般写上小括号
  println(myCounter.current) // 对于取值器，可以省略小括号
}

class Counter {
  // 你必须初始化属性值
  private var value = 0

  // 方法默认是共有的
  def increment(): Unit = {
    value += 1
  }

  def current: Int = value  // 这里强制取值方法在调用的时候不用小括号。
}