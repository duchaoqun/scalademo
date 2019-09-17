package cn.duchaoqun.Chapter3

/**
  * 3.4 数组转换
  * 从一个数组或者缓冲数组出发，以某种方式对他进行转换，产生一个新的数组（不会改变原来数组）。
  */
object Demo3_4 extends App {
  val a = Array(1, 2, 3, 4, 5, 6)
  // 创建了一个与原始类型相同的集合
  val res1 = for (x <- a) yield x * 2
  val res2 = for (x <- a if x % 2 == 0) yield 2 * x // 过滤出偶数，然后乘以2
  val res3 = a.filter(_ % 2 == 0).map(2 * _) // 过滤出偶数，然后乘以2
  val res4 = a.filter { _ % 2 == 0 } map { 2 * _ } // 过滤出偶数，然后乘以2

}
