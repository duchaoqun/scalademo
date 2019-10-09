package cn.duchaoqun.Chapter12

object Demo22 extends App {
  // foldRight 提供一个初始值, 然后集合最右边的元素减去10, 然后集合右边第二个元素减去前一步结果, 然后右边第三个元素减去前一步结果...
  // 实际效果: 1 - ( 2 - ( 3 - ( 4 - ( 5 - 10 ) ) ) )
  println((1 to 5).foldRight(10)(_ - _))
  println((1 to 5).foldRight(10)((a, b) => {
    println(s"$a - $b")
    a - b
  }))
}
