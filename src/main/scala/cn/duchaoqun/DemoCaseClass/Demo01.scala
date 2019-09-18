package cn.duchaoqun.DemoCaseClass

// case class 中的参数默认就是 val 类型，不需要再使用 val 进行声明。
// case class Demo01_Host(val address:String ,val port:Int)
case class Demo01_Host(address: String, port: Int)


// 重写 toString 方法。
case class Demo01_Host1(address: String, port: Int) {
  override def toString: String = {
    "Host info:" + address + ":" + port
  }
}

// 定义一个 Exception 类型。
case class DCC03_Exception(msg: String) extends Exception


/**
  * 说明: 设计一个类只是用来作为数据载体时，Case Class 是一个很好的选择，实际上，这正是DTO（或者也有叫作VO）做的事情。
  * 所以说Case Class的一个典型应用场景就是DTO。
  */
object Demo01 extends App {
  // 伴生对象自动包含 apply 方法，代替new方式声明对象。
  val host1 = Demo01_Host("127.0.0.1", 8080)
  val host2 = Demo01_Host.apply(address = "127.0.0.1", port = 8080)


  // 将 case class 转换成一个 List
  val host3 = Demo01_Host("127.0.0.1", 8080).productIterator.toList // List(114.114.114.114, 123)

  // 将 list 转换成 case class
  val list1 = List("127.0.0.1", 8080)
  Demo01_Host.getClass.getMethods.find(x => x.getName == "apply" && x.isBridge).get.invoke(Demo01_Host, list1 map (_.asInstanceOf[AnyRef]): _*).asInstanceOf[Demo01_Host]
  // 将 list 转换成 case class
  list1 match {
    case List(x: String, i: Int) => Demo01_Host(x, i)
  }

  // 到目前为止, 仅支持从Tuple创建一个 Case Class 对象
  val host4 = Demo01_Host.tupled(("127.0.0.1", 8080))

  // 伴生对象自动包含 unapply 方法，获取对象内容
  val someHost: scala.Option[(String,Int)] = Demo01_Host.unapply(host1)
  println(someHost.get)


  // todo：
  // host1.hashCode()
  // host1.toString
  // host1.equals()
  // val p3 = host1.isInstanceOf[Host]
  // val p4 = host1.asInstanceOf[Host]
}
