package info.aoye.Chapter11

import scala.collection.mutable

/**
  * 11.7 apply 和 update 方法
  */
object Demo11_7 extends App {
  // Scala 允许你将如下的函数调用语法：f(arg1, arg2, ...) 扩展到可以应用于函数之外的值。
  // 如果 f 不是函数或方法，那么这个表达式就等同于调用 f.apply(arg1, arg2, ...)

  // 如果它出现在赋值语句等号的左侧：
  //   f(arg1, arg2, ...) = value
  //   f.update(arg1, arg2, ..., value)
  // 这个机制被应用于 Array 和 Map 中：
  val scores = new mutable.HashMap[String,Int]()
  scores("Bob") = 100
  scores.update("Chris", 100)
  println(scores)

  // 如果它出现在赋值语句等号的右侧：
  val bobScore1 = scores("Bob")
  val bobScore2 = scores.apply("Bob")

  // apply 方法同样经常被应用在伴生对象中，用来构造对象，替代显示的使用 new 的方式来构造。
  val result1 = Fraction11(1, 2)
  val result2 = new Fraction11(1, 2)
}


class Fraction11(n:Int ,d:Int){
}

object Fraction11{
  def apply(n: Int, d: Int): Fraction11 = new Fraction11(n, d)
}
