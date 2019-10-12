package cn.duchaoqun.Chapter10

import java.util.Date

object Demo05 extends App {

  trait Logged {
    def log() {}
  }

  trait ConsoleLogged extends Logged {
    def log(msg: String) {
      println(msg)
    }
  }

  // 我们可能想给所有日志消息添加时间戳。
  trait TimestampLogged extends ConsoleLogged {
    override def log(msg: String): Unit = {
      super.log(new Date() + ":" + msg)
    }
  }

  // 同样，我们想获取更短的日志。
  trait ShortLogged extends ConsoleLogged {
    val maxLength = 15
    override def log(msg: String): Unit = {
      super.log(
        if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
    }
  }

  // 上述两个方法，每一个都将修改后的 msg 传递给 super.log

  class Test extends ConsoleLogged {
    def printLog(): Unit ={
      log("这里是一个超级超级超级超级超级超级超级长的Log！")
    }
  }

  // 实际上，super.log 调用的是特质顺序中的下一个，具体是那个，需要根据顺序来决定，一般特质从最后一个开始处理。
  val a = new Test with ConsoleLogged with TimestampLogged with ShortLogged
  a.printLog() // Sat Oct 12 17:12:46 CST 2019:这里是一个超级超级超级超...
  // 这里 ShortLogged 先被调用，然后它的 super.log 调用的是 TimestampLogged

  val b = new Test with ConsoleLogged with ShortLogged with TimestampLogged
  b.printLog() // Sat Oct 12 1...
  // 这里 TimestampLogged 先被调用，然后才是ShortLogged，导致后面的内容都丢了。

  // 说明： 对于 Trait 来说，你无法从源代码判断 super.SomeMethod 会执行哪里的方法
  //        确切被调用的方法依赖于这些特质对象被给出的顺序，这使得 super 相比在传统的用法中灵活得多

  // 提示： 如果你需要控制具体是哪一个特质的方法被调用，则可以在方括号中给出名称：
  //        super[ConsoleLogged].log(...) 这里给出的类必须是直接父类型；
  //        你无法使用继承层级中更远的特质或类。

}



