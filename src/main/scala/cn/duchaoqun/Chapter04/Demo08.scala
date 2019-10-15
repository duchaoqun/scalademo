package cn.duchaoqun.Chapter04

import scala.language.postfixOps

object Demo08 extends App {

  // 使用 Tuple 的原因之一是把多个值绑定在一起，以便让它们能够一起处理，这通常可以使用 zip 来完成。
  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)

  // 拉链操作，返回Array((<,2), (-,10), (>,2))
  val pairs0 = symbols.zip(counts)
  val pairs1 = symbols zip counts toMap

  // 使用 toMap 方法可以将对偶的集合，转换成 Map 集合。
  pairs0.toMap // 可以转换成数组
  println(pairs0.toList)
}
