package cn.duchaoqun.Chapter13

import scala.io.Source

object Demo09 extends App {

  def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)

  // #:: 操作符很像是列表的 :: 操作符，只不过它构建出来的是一个流。
  val tenOrMore = numsForm(10)
  // Stream(10,?)
  // 它的后面是没有被求值的，流的方法是懒执行的。

  // 你需要调用 tail 方法来强制对下一个元素求值。
  val x = tenOrMore.tail           // 取一个元素

  val y = tenOrMore.take(5).force  // 取五个元素

  // 也可以从一个迭代器中创建 Stream
  val html = Source.fromURL("https://www.duchaoqun.cn").getLines.iterator.toStream
}
