package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo07 extends App {
  val set_1 = mutable.Set(1, 2, 3, 4)
  // 可变的 Set 在添加元素之后返回自身。
  set_1 += 5

  println(set_1)
}
