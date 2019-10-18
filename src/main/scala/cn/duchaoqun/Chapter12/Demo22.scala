package cn.duchaoqun.Chapter12

object Demo22 extends App {
  // foldRight 提供一个初始值，然后集合最右边的元素减去10，然后集合右边第二个元素减去前一步结果，然后右边第三个元素减去前一步结果...
  // 初始值，和函数参数是分开定义的“柯里化”参数，这样 Scala 就能从初始值的类型推断出操作符的类型定义。
  // 实际效果: 1 - ( 2 - ( 3 - ( 4 - ( 5 - 10 ) ) ) )
  println((1 to 5).foldRight(10)(_ - _))
  println((1 to 5).foldRight(10)((a, b) => {
    println(s"$a - $b")
    a - b
  }))

  // 2.13.0 以前版本可用的写法
  (1 to 5).:\(10)( _ - _)  // 过期
}
