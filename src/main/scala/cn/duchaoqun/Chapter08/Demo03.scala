package cn.duchaoqun.Chapter08

object Demo03 extends App {

  val test1 = "String"

  // isInstanceOf：检查某个对象是否属于某个给定的类。
  // asInstanceOf：将引用转换为子类的引用。
  println(test1.isInstanceOf[String])

  // 这是一种写法
  // 如果 test1 指向的是 String 类或者它的子类的对象，则返回 true。
  // 如果test1是null，则返回false，且asInstanceOf[String]返回的也是null
  // 如果test1不是String类型，则test1.asInstanceOf[String]抛出异常
  if (test1.isInstanceOf[String]) test1.asInstanceOf[String]

  // 这是一种更常见的写法
  test1 match {
    case str: String => str
    case _ =>
  }

  // 如果你想测试 test 是 String 对象，但不是其子类的话，可以使用如下方法。
  // classOf[] 方法定义在 scala.Predef对象中（默认引用）
  if(test1.getClass == classOf[String]) {}


  /*
  //  Java 与 Scala 的一些对应关系
  Scala中：obj.isInstanceOf[C1]
  Java 中：obj instanceof C1

  Scala中：obj.asInstanceOf[C1]
  Java 中：(C1)obj

  Scala中：classOf[C1]
  Java 中：C1.class
   */
}
