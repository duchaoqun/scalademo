package cn.duchaoqun.Chapter04

import scala.collection.mutable

object Demo03 extends App {

  val scores = mutable.Map("Scala" -> 10, "Java" -> 8)
  val other = Map("Phton" -> 9, "Groovy" -> 8)

  // 添加或者更新键值
  scores.addOne("Spark" -> 100)       // 添加单个键值对
  scores += ("JS" -> 10, "SQL" -> 10) // 添加多个键值对
  scores.addAll(other)                // 添加多个键值对
  scores("Groovy") = 7                // 新增或者更新已有的键值
  scores -= "Java" // 删除键值对

  // 你不能更新一个不可变的Map，但是你可以做一些同样有用的操作。
  val map0 = Map("A" -> 1, "B" -> 2)
  val map1 = map0 + ("B" -> 22, "C" -> 3)  // 创建一个新的Map，更新了 B 的内容，插入了 C
  val map2 = map0 - "B"                    // 创建一个新的Map，移除一个键值对。
  // 新的 Map 和老的 Map 共享大部分结构，不影响太多效率。
}
