package cn.duchaoqun.Chapter10

object Demo03 extends App {

  trait Logger {
    // 特质中的方法不一定是抽象的，可以有具体的方法体。
    def log(msg: String) {
      println(msg)
    }
  }

  /**
    * 这里 Saving 类从 Logger 得到了一个 log 方法，在 Java 中是不能实现的。
    * 这里我们说：Logger 的功能被混入了 Saving 类（Saving 类混入了 Logger 的功能）。
    * 弊端：当特质改变时，所有混入了该特质的类都需要重新编译。
    */
  class Saving extends Logger {
    def withdraw(): Unit = {
      log("Scala")
    }
  }

}