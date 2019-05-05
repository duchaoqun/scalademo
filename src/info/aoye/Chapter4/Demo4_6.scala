package info.aoye.Chapter4

/**
  * 4.6 Scala与Java的互操作
  * 调用Java方法会返回Java类型的Map，或者传递给Java方法的参数需要Java类型的Map
  */
object Demo4_6 extends App {
  import scala.collection.JavaConversions.mapAsScalaMap // 接受到的转换成ScalaMap
  import scala.collection.JavaConversions.mapAsJavaMap  // 将ScalaMap转换成JavaMap
}
