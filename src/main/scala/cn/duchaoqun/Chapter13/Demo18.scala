package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo18 extends App {
  // 元素存在顺序, 内容不重复
  val linkedHashSet1 = mutable.LinkedHashSet(1,2,3)

  // 添加元素
  linkedHashSet1 += 40
  linkedHashSet1 += 5
  linkedHashSet1.add(55)

  // 删除元素
  linkedHashSet1.remove(2)
  println(linkedHashSet1)
}
