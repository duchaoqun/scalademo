package cn.duchaoqun.Chapter04

import scala.collection.mutable

/**
  * 1 定义Map
  */
object Demo1 extends App {

  // 定义一个不可变(immutable)的Map[String, Int]
  val scores0 = Map("Scala" -> 10, "Java" -> 8)
  // 定义一个可变的Map[String, Int]
  val scores1 = mutable.Map("Scala" -> 10, "Java" -> 8)
  // 从一个空的Map开始，需要选定一个映射实现并给出类型参数
  val scores2 = new mutable.HashMap[String, Int]

  // Map是键值对的集合，使用->定义键值对
  "Scala" -> 10 // ("Scala",10)
  ("Scala" , 10) // ("Scala",10)
  // 也可以如下定义，但是-> 更加直观。
  val scores3 = mutable.Map(("Scala" , 10),("Java" , 8))
}
