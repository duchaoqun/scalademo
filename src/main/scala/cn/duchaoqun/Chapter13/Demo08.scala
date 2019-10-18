package cn.duchaoqun.Chapter13

object Demo08 extends App {
  val digits_1 = Set(9,1,3,5,7)
  val digits_2 = Set(1,3,5,2)

  digits_1.contains(0)                 // 检查 Set 是否包含某个元素。
  digits_2.subsetOf(digits_1)          // 检查 Set 是否是另外一个 Set 的子集。

  digits_1 union digits_2              // 取两个 Set 中所有元素。
  digits_1 intersect digits_2          // 取两个 Set 都有的元素。
  println(digits_1 diff digits_2)      // 取 1 中有，2 中没有的元素。
}
