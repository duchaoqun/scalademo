package cn.duchaoqun.Chapter12

object Demo21 extends App {
  // foldLeft 提供一个初始值10，然后从集合左边开始操作，10 - 第一个元素，然后结果再减去第二个元素，然后结果再减去第三个元素...
  // 初始值，和函数参数是分开定义的“柯里化”参数，这样 Scala 就能从初始值的类型推断出操作符的类型定义。
  // 实际效果: ( ( ( ( 10 - 1 ) - 2 ) - 3 ) - 4 ) - 5
  println((1 to 5).foldLeft(10)(_ - _))
  println((1 to 5).foldLeft(10)((a, b) => {
    println(s"$a - $b")
    a - b
  }))

  // 2.13.0 以前版本可用的写法
  (1 to 5)./:(10)( _ - _)  // 过期
}
