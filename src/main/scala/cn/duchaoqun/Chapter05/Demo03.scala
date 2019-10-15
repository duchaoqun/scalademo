package cn.duchaoqun.Chapter05

object Demo03 extends App {
  class Message {
    // 有时候你需要一个只读属性，有 getter 但是没有 setter，如果属性的值在对象创建完成之后就不会再改变，则可以使用 val 关键字。
    // 这里 Scala 会生成一个 final 字段和一个 getter 方法，并没有 setter 方法。
    val timeStamp = new java.util.Date
  }

  val msg = new Message

  println(msg.timeStamp)
  Thread.sleep(1000)
  println(msg.timeStamp)

  // 在实现属性的时候你有如下四种选择：
  // var foo:  Scala 自动创建 getter/setter
  // val foo： Scala 自动创建 getter
  // 我们自己定义 foo 和 foo_= 方法。
  // 我们自己定义 foo 方法。
}


