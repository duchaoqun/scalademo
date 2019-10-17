package cn.duchaoqun.Chapter10

import java.io.IOException

import javax.swing.JFrame

object Demo12 extends App {

  trait Logged {
    def log(msg: String)
  }

  trait LoggedException extends Exception with Logged {
    override def log(msg: String) {
      // 注意：log 方法调用了父类 Exception 中的 getMessage 方法。
      log(getMessage)
    }
  }

  // 现在创建一个混入该特质的类，这时候特质的父类会自动成为我们这个类的父类。
  class UnhappyException1 extends LoggedException{
    override def getMessage: String = "Java"
  }

  // 可以再扩展一个类，只要这个被扩展的类是那个特质所扩展的类的子类即可。
  // 下面的 UnhappyException2 扩展了 IOException 类，而这个 IOException 类已经扩展了 Exception 类。
  class UnhappyException2 extends IOException with LoggedException{}

  // 如果我们的类扩展了一个不相关的类 JFrame 那么我们就不能再混入该特质了。
  // 我们不能同时将 JFrame 和 Exception 作为父类。
  // class UnhappyFrame extends JFrame with LoggedException{}
}
