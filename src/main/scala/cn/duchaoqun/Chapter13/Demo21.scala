package cn.duchaoqun.Chapter13

object Demo21 extends App {
  // sortedSet 会自动把插入的元素进行排序.
  val sortedSet1 = scala.collection.mutable.SortedSet(1,2,3,5,4,50)
  println(sortedSet1)
}
