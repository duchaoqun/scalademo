package cn.duchaoqun.Chapter10

object Demo04 extends App {

  // 这个是标准库的Logged特质，它自带的 log 方法什么都没有实现( 这里定义了方法，只是方法体是空的，在继承的时候需要使用 override 关键字)。
  trait Logged {
    def log(msg: String) {}
  }

  // 扩展的特质，更好的实现了 Logged 特质中的 log 方法。
  trait Logger1 extends Logged {
    override def log(msg: String): Unit = println("Logger1:" + msg)
  }

  // 扩展的特质，更好的实现了 Logged 特质中的 log 方法。
  trait Logger2 extends Logged {
    override def log(msg: String): Unit = println("Logger2:" + msg)
  }


  // 然后我们在定义一个类，继承这个特质。
  class Person extends Logged {
    // 这里的log方法看上去毫无意义！log 里面没有方法体。
    def MySelf: String = {
      log("Print Log...")
      "My name is Scala!"
    }
  }

  // 这时我们就可以在创建对象的时候，混入一个更有意义的 log 方法，然后调用的时候就可以执行更好的 log 了。
  val a = new Person with Logger1
  a.log("Scala")
  // 当然另外一个对象，也可以混入另外的特质。
  val b = new Person with Logger2
}

