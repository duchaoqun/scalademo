package cn.duchaoqun.Chapter04

import scala.collection.mutable

/**
  * 6 Scala与Java的互操作
  * 调用Java方法会返回Java类型的Map，或者传递给Java方法的参数需要Java类型的Map
  */
object Demo6 extends App {

  //历史包：已经弃用
  //import scala.collection.JavaConversions.*

  //现在使用的包：也将被弃用
  import scala.collection.JavaConverters.mapAsScalaMap // 接受到的转换成ScalaMap
  import scala.collection.JavaConverters.mapAsJavaMap  // 将ScalaMap转换成JavaMap

  // Scala 2.13.0 asScala
}