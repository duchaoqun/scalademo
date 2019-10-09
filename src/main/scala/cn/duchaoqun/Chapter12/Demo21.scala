package cn.duchaoqun.Chapter12

object Demo21 extends App {
  // foldLeft 提供一个初始值10 ,然后从集合左边开始操作, 10 - 第一个元素, 然后结果再减去第二个元素, 然后结果再减去第三个元素...
  // 实际效果: ( ( ( ( 10 - 1 ) - 2 ) - 3 ) - 4 ) - 5
  println((1 to 5).foldLeft(10)(_ - _))
  println((1 to 5).foldLeft(10)((a, b) => {
    println(s"$a - $b")
    a - b
  }))
}
