package cn.duchaoqun.Chapter10

object Demo02 extends App {

  trait Logger {
    // 定义一个抽象的方法，这里不需要使用 abstract 关键字来修饰，在 Trait 里面，没有方法体的默认就是抽象方法。
    def log(msg: String)
  }

  // 在继承多个 Trait 的时候，后面的使用 with 关键字。
  // 在 Java 中的所有 interface 都可以作为 trait 来使用。
  class ConsoleLogger extends Logger with Cloneable with Serializable {
    // 在重写 Trait 中的抽象方法（没有方法体）的时候，不需要使用 override 关键字。
    def log(msg: String): Unit = {
      println("msg")
    }
  }


  // 注意：在第一个 trait (Logger) 使用 extends ，后面的使用 with 感觉上有些奇怪，但是在 Scala 中的理解方式是：
  //       Logger with Cloneable with Serializable 先是一个整体，然后再被Logger继承。

}