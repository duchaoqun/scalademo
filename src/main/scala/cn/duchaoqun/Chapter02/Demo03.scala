package cn.duchaoqun.Chapter02

import math._

object Demo03 extends App {
  // 使用花括号包围起来的语句集合，通常用来初始化一个 val，当这个 val 需要很多步骤来初始化的时候。
  val x_1 = {
    val y = 1
    val z = 2
    sqrt(y + z) // 块表达式的最后一行就是这个块的结果
  }

  val x_2: Unit = {
    var y = 1
    var z = 2
    y += z // 注意，这里是赋值表达式！ 赋值语句的结果是 Unit 类型，也就是什么都没有，使用的时候需要注意。
  }

  println(x_1)
  println(x_2)
}
