package cn.duchaoqun.Chapter12

object Demo28 extends App {

  // 定义产品和数量两个集合
  val prices = List(10.00, 25.00, 100.00)
  val quantities = List(10, 4, 2)

  // 使用 zip 函数，将他们组合成一个对偶的列表。
  val res = prices zip quantities // List[(Double, Int)] = List((10.0,10), (25.0,4), (100.0,2))

  // 计算每类商品总价
  import scala.language.postfixOps
  val total = res.map(p => p._1 * p._2) sum

  // 如果一个集合比另外一个集合短，那么结果对偶的数量和较短的那个集合元素数量相等。
  val list1 = List(12, 34, 56, 78)
  val list2 = List(23, 45, 67)

  val res2 = list1 zip list2 // List[(Int, Int)] = List((12,23), (34,45), (56,67))

  // 使用 zipAll 方法，可以让我们设置较短集合的默认值。
  val res3 = list1.zipAll(list2, 0.0, 0) // List[(AnyVal, Int)] = List((12,23), (34,45), (56,67), (78,0))

  // 使用 zipWithIndex 方法返回对偶的列表，其中每个对偶中第二个组成部分是每个元素的下标。
  // 这在计算具备某种属性的元素的下标时很有用。
  val res4 = list1.zipWithIndex  // List[(Int, Int)] = List((12,0), (34,1), (56,2), (78,3))
  val res5 = list1.zipWithIndex.max // (Int, Int) = (78,3)

}
