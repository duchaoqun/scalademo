package cn.duchaoqun.Chapter14

object Demo07 extends App {

  // 可以在定义变量的时候使用模式匹配
  val (x, y) = (1, 2)

  // 这对于返回对偶的函数而言非常有用，/% 函数返回商和余数的对偶，这两个值分别赋值给 q 和 r。
  val (q, r) = BigInt(10) /% 3

  // 同样的语法可以适用于任何带有变量的模式中。
  val array = Array(1, 2, 3)
  val Array(first, second, _*) = array
}
