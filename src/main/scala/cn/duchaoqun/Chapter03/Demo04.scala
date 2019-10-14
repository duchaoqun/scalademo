package cn.duchaoqun.Chapter03

object Demo04 extends App {
  val a = Array(1, 2, 3, 4, 5, 6)
  // 创建了一个与原始类型相同的集合
  val res1 = for (x <- a) yield x * 2
  val res2 = for (x <- a if x % 2 == 0) yield 2 * x // 过滤出偶数，然后乘以2
  val res3 = a.filter(_ % 2 == 0).map(2 * _) // 过滤出偶数，然后乘以2
  val res4 = a.filter { _ % 2 == 0 } map { 2 * _ } // 过滤出偶数，然后乘以2

}
