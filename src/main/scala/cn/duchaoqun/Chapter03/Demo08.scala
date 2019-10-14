package cn.duchaoqun.Chapter03

object Demo08 extends App {

  // import scala.collection.JavaConversions.bufferAsJavaList  // 过期
  // import scala.collection.JavaConverters.bufferAsJavaList   // 过期
  import scala.jdk.CollectionConverters._                      // Scala 2.13.0
  import scala.collection.mutable.ArrayBuffer

  val command = ArrayBuffer("ls", "-a", "/home")

  // Java 到 Scala 的转换
  // java.long.ProcessBuilder 类有一个以 List<String> 为参数的构造器
  val pb = new ProcessBuilder(command.toString)
  val cmd = pb.command()

  // Scala 到 Java 的转换
  val scalaSet = collection.mutable.Set(1,2,3)
  val javaSet = scalaSet.asJava  // 转换为 java.util.Set 类型对象
}
