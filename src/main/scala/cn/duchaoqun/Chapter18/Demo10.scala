package cn.duchaoqun.Chapter18

import javax.swing.JFrame

object Demo10 extends App {

  // “特质”可以要求混入它的类扩展自另外一个类型。
  // 你用“自身类型（self type）”的声明来定义特质：
  // this: 类型 =>

  // 这样的特质只能被混入给定类型的子类当中。

  trait Logged {
    def log(msg: String)
  }

  trait LoggedException extends Logged {
    this: Exception =>
    def log() {
      log(getMessage) // 可以调用 getMessage方法，因为 this 是一个 Exception
    }
  }

  // 如果你尝试将该特质混入不符合自身类型所要求的类，就会报错：
  // val f = new JFrame with LoggedException

  // 如果你想要提出多个类型要求，可以用复合类型
  // this: T with U with ... =>


  // 注意：自身类型并不会自动继承，你需要重复自身类型的声明。
  trait ManagedException extends LoggedException{
    this: Exception =>
    override def log(): Unit = {
      log(getMessage)
    }
  }

}
