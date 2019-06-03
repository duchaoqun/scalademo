package info.aoye.Chapter10

/**
  * 10.4 带有特质的对象
  */
object Demo10_4 extends App {
  // 可以在创建对象的时候，混入一个更有意义的log方法，然后调用的时候就可以执行更好的log了。
  val a = new Demo10_4_1 with Demo10_4_2
  a.log("Scala")
  // 当然另外一个对象，也可以混入另外的特质。
  val b = new Demo10_4_1 with Demo10_4_3
}

/**
  * 这个是标准库的Logged特质，它自带的log方法什么都没有实现。
  */
trait Logged {
  def log(msg:String) {}
}


/**
  * 扩展的特质，更好的实现了Logged特质。
  */
trait Demo10_4_2 extends Logged{
  override def log(msg: String): Unit = println("Demo10_4_2:" + msg)
}


/**
  * 扩展的特质，更好的实现了Logged特质。
  */
trait Demo10_4_3 extends Logged{
  override def log(msg: String): Unit = println("Demo10_4_3:" + msg)
}


/**
  * 这里的log方法看上去毫无意义！
  */
class Demo10_4_1 extends Logged{
}
