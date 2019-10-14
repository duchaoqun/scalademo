package cn.duchaoqun.Chapter10

object Demo09 extends App {

  trait Logged {
    val maxLength: Int

    def log(msg: String) {
      println(msg)
    }
  }

  // 特质中未被初始化的字段在其子类中必须予以实现。
  // 这里不写 override 也行，但感觉还是写上比较好理解。
  class Test1 extends Logged {
    override val maxLength: Int = 12
  }

  class Test2 {}

  // 这种提供特质参数的方式在你临时要构造某个对象时非常便利。
  val a = new Test2 with Logged {
    val maxLength: Int = 12
  }

}
