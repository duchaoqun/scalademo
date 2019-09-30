package cn.duchaoqun.Chapter4

import scala.language.postfixOps
/**
  * 8 拉链操作
  */
object Demo8 extends App {

  // 使用Tuple的原因之一是把多个值绑定在一起，以便让它们能够一起处理，这通常可以使用zip来完成。
  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)

  // 拉链操作，返回Array((<,2), (-,10), (>,2))
  val pairs0 = symbols.zip(counts)
  val pairs1 = symbols zip counts toMap

  pairs0.toMap // 可以转换成数组
  println(pairs0.toList)
}
