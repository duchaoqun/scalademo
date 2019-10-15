package cn.duchaoqun.Chapter04

object Demo04 extends App {

  val map0 = Map("A" -> 1, "B" -> 2)

  // 循环所有的内容
  for ((k, v) <- map0) {
    println(k + ":" + v)
  }

  // 反转一个Map
  for ((k, v) <- map0) yield (v, k)

  map0.keys
  map0.keySet
  map0.values
}
