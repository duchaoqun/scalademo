package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo17 extends App {
  val hashSet1 = mutable.HashSet(1,2,3,4,5)
  hashSet1.add(65)        // 添加一个元素
  hashSet1.remove(4)      // 删除一个元素
  hashSet1.clear()        // 清空元素
  println(hashSet1.size)  // 查看集合大小

  val set = mutable.HashSet("a","b")
}
