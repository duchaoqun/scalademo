package cn.duchaoqun.Chapter10

import java.util.Date

object Demo06 extends App {

  trait Logger {
    def log(msg: String) // 这是一个抽象方法，没有方法体。
  }

// 如下是一个错误的写法：
//  trait TimestampLogger extends Logger {
//    override def log(msg: String): Unit = { // 重写抽象方法
//      // 虽然 IDEA 没有提示错误，但是这里编译器提示了错误。
//      super.log(new Date() + ":" + msg)
//    }
//  }
// 根据正常的继承规则，这个调用永远都是错误的，Logger.log 方法没有方法体，它是抽象的。
// 但是实际上我们没有办法知道那个 log 方法会被最终调用，这取决于特质被混入的顺序。
// Scala 认为 TimestampLogger 依旧是抽象的（它需要混入一个具体的log方法）
// 因此必须给方法使用 abstract 和 override 关键字进行修饰。
  trait TimestampLogger extends Logger{
  abstract override def log(msg: String): Unit = {
    super.log(new Date() + ":" + msg)
  }
}


}
