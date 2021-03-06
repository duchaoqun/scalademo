package cn.duchaoqun.Chapter03

object Demo03 extends App {
  val arr1 = Array(1, 2, 3, 4, 5, 6, 7, 8)

  for (x <- 0 until arr1.length) {
    println(arr1(x))
  }

  for (x <- arr1.indices) {
    println(arr1(x))
  }

  0 until(arr1.length, 2) // Range(0,2,4,6,...)
  (0 until arr1.length).reverse // 倒序

  for (x <- arr1) {
    println(x)
  }
}
