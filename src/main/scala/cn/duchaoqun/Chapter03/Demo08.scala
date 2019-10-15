package cn.duchaoqun.Chapter03

import java.util

object Demo08 extends App {

  // 导入上面的包之后就可以使用下面的asScala方法，然后asJava就可以转换成Java的集合类型了。
  // import scala.collection.JavaConversions.bufferAsJavaList  // 过期
  // import scala.collection.JavaConverters.bufferAsJavaList   // 过期
  import scala.jdk.CollectionConverters._ // Scala 2.13.0

  // Java 到 Scala 的转换：使用 asScala
  var javaList = new util.ArrayList[String]() // java.util.ArrayList
  javaList.add("Scala")
  javaList.add("Java")
  val res1 = javaList.asScala
  println(res1.getClass)

  // Scala 到 Java 的转换：使用 asJava
  val scalaList = List("Scala", "Java")
  val res2 = scalaList.asJava
  println(res2.getClass)


  // 其他对象转换成 Java 的方式。
  var scalaMap = Map(1 -> "Scala")
  val res3 = scalaMap.asJava

}
