package cn.duchaoqun.Chapter3

/**
  * 3.7 多维数组
  * 通过数组的数组来实现
  */
object Demo3_7 extends App {
  // 定义一个3行4列的二维数组，注意需要类型
  val matrix = Array.ofDim[Double](3, 4)
  // 访问二维数组中的元素
  println(matrix(2)(3))

  //TODO：创建不规则的数组，每行的长度各不相同
  val triangle = new Array[Array[Int]](10)
  for ( i <- 0 to triangle.length) triangle(i) = new Array[Int](i + 1)
}
