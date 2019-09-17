package cn.duchaoqun.Chapter8

/**
  * 8.3 类型检查和转换
  *
  * 要测试某个对象是否属于某个类，可以使用isInstanceOf方法，如果监测成功，就可以使用asInstanceOf转换成该类的引用。
  */
object Demo8_3 extends App {
  val test1 = "String"

  println(test1.isInstanceOf[String])

  // 这是一种写法
  // 如果test1指向的是String类或者它的子类的对象，则返回true
  // 如果test1是null，则返回false，且asInstanceOf[String]返回的也是null
  // 如果test1不是String类型，则test1.asInstanceOf[String]抛出异常
  if (test1.isInstanceOf[String]) test1.asInstanceOf[String]

  // 这是一种更常见的写法
  test1 match {
    case str: String => str
    case _ =>
  }

  // 如果你想测试test是String对象，但不是其子类的话，可以使用如下方法
  // classOf[] 方法定义在 scala.Predef对象中（默认引用）
  if(test1.getClass == classOf[String]) {}
}
