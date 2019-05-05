package info.aoye.Chapter3

import scala.collection.mutable

/**
  * 3.8 Scala与Java的互操作
  * 如果你调用“接受或者返回java.util.List”的Java方法
  */
object Demo3_8 extends App {

  //java.long.ProcessBuilder类有一个以List<String>为参数的构造器
  import scala.collection.JavaConversions.bufferAsJavaList
  //import scala.collection.JavaConverters.bufferAsJavaList  //TODO：上面方法不被推荐，这里又不能用！
  import scala.collection.mutable.ArrayBuffer

  val command = ArrayBuffer("ls", "-a", "/home")
  val pb = new ProcessBuilder(command) // Scala 到 Java 的转换

  import scala.collection.JavaConversions.asScalaBuffer

  val cmd: mutable.Buffer[String] = pb.command() // Java 到 Scala 的转换

}
