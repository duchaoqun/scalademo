package cn.duchaoqun.Chapter5

/**
  * 5.1 简单类和无参方法
  */
object Demo1 extends App {
  val myCounter = new Counter
  // 调用无参方法可以省略小括号
  myCounter.increment()      // 对于改变对象状态的一般写上小括号。
  println(myCounter.current) // 对于取值方法，可以省略小括号。
}

/**
  * 定义一个简单的类
  * 使用 class 关键字定义一个类，然后使用 new class 的方式创建这个类的对象。
  * 类并不用 public 关键字进行修饰，一个Scala源文件中可以包含多个Class，所有这些类都具有共有可见性。
  */
class Counter {
  // 必须初始化属性值
  private var value = 0

  // 方法默认是公有的
  def increment(): Unit = {
    value += 1
  }

  // 定义一个取值方法
  def current: Int = value
}