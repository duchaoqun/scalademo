package info.aoye.Chapter2

import math._

/**
  * 2.3 块表达式和赋值
  */
object Demo2_3 extends App {
  // 使用花括号包围起来的语句集合，通常用来初始化一个val，当这个val需要很多步骤来初始化的时候。
  val x_1 = {
    val y = 1
    val z = 2
    sqrt(y + z) // 块表达式的最后一行就是这个块的结果
  }

  val x_2: Unit = {
    var y = 1
    var z = 2
    y += z // Note 留意，这里是赋值表达式！ 赋值语句的结果是Unit类型，也就是什么都没有，使用的时候需要注意。
  }
  println(x_2)
}
