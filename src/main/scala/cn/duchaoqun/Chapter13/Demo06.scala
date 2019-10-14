package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo06 extends App {

  // 使用伴生对象的 apply 方法创建 set 对象。
  val set_1 = Set(1, 2, 3, 3, 4, 5)

  // 添加元素：使用 + 操作符添加值，immutable 类型的返回包含元素的新的 set 集合。
  val set_2 = set_1 + 6

  // 和 List 不同， Set 并不保存元素的插入顺序
  set_1.foreach(println(_)) // 5, 1, 2, 3, 4

  // LinkedHashSet 会记住元素被插入的顺序，他会维护一个链表来达到这个目的。
  val weekdays = mutable.LinkedHashSet("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

  // 2.9.0 没有这个类库
  // 如果你想按照已排序的顺序来访问集合元素，可使用SortedSet，是使用红黑树实现的。
  // val set_2 = mutable.SortedSet(1, 2, 3, 4, 5)
  // set_2.foreach(println(_))

  // todo; BitSet 都有哪些应用场景？
  val set_3 = mutable.BitSet

  // 检查集合中是否包含某个元素
  val isExist = set_1.contains(5)

  // 检查 set_2 是否是 set_1 的子集
  // val isSubSet = set_2.subsetOf(set_1)


  // Set 常规操作
  // todo; 交集 并集 子集 ...
}
