package cn.duchaoqun.Chapter3

import scala.collection.mutable

/**
  * 3.8 Scala与Java的互操作
  * 如果你调用“接受或者返回java.util.List”的Java方法
  */
object Demo3_8 extends App {

  //java.long.ProcessBuilder类有一个以List<String>为参数的构造器
  //import scala.collection.JavaConversions.bufferAsJavaList  // 已经弃用
  import scala.collection.JavaConverters.bufferAsJavaList  //TODO：上面方法不被推荐，这里又不能用！
  import scala.collection.mutable.ArrayBuffer

  val command = ArrayBuffer("ls", "-a", "/home")
  val pb = new ProcessBuilder(command.toString) // Scala 到 Java 的转换?


  val cmd = pb.command() // Java 到 Scala 的转换?


  // 在 scala 2.13.0 中
  import scala.jdk.CollectionConverters._
  val mSet = collection.mutable.Set(1,2,3)
  // 转换为 java.util.Set 类型对象
  mSet.asJava
}
