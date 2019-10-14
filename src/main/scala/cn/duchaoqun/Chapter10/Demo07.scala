package cn.duchaoqun.Chapter10

object Demo07 extends App {

  // 让我们来丰富一下功能少得可怜的日志 API 吧。
  // 通常日志 API 允许你为每一个日志消息指定一个级别，用来区分类的消息，告警，错误等。
  // 我们可以很容易的添加这个功能，而不规定日志消息要记录到那里去。

  trait Logger {
    def log(msg: String)

    def info(msg: String) {
      log("INFO:" + msg)
    }

    def warn(msg: String) {
      log("WARN:" + msg)
    }

    def severe(msg: String) {
      log("SEVERE:" + msg)
    }
  }

  // 注意我们是怎样把抽象方法和具体方法结合在一起的。
  // 这样使用 Logger 特质的类就可以任意的调用这些方法了。

  class SavingAccount extends Logger {
    def withdraw(amount: Double) {
      if (amount > 100) severe("Scala") else info("Scala!")
    }

    override def log(msg: String): Unit = {println(msg)}
  }

}
