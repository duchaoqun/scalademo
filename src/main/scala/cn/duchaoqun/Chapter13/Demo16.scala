package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo16 extends App {
  // Map 是一个 trait , 在使用的时候我们需要实例化其子类对象HashMap

  // 创建一个车 HashMap 对象
  val hashMap = new mutable.HashMap[Int, String]()

  // 添加数据
  hashMap += (1 -> "Scala")
  hashMap.put(2, "Java")

  // 提取元素
  val res1 = hashMap(1)

  // 更新元素值
  hashMap.update(1, hashMap(1) + 1)

  // 判断是否包含这个元素
  hashMap.contains(1)

  println(hashMap)
}
