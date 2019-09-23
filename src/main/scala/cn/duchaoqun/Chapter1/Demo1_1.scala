package cn.duchaoqun.Chapter1

object Demo1_1 extends App {

  // 每个表达式都有一个类型，例如 “val x = 1” 这个表达式就是Int类型。
  val x = 1

  // 条件表达式 if 是有返回值的，可以把他的值赋给一个对象。
  val res1 = if (x < 1) 1 else 0

  // () 表示Unit 对象，代表什么都没有。
  val a: Unit = ()

  // 每个 Scala 集合特质或者类都有一个带有 apply 方法的伴生对象，这个方法可以用来创建该集合的实例。【统一创建原则】
  val set1 = Set(1, 2, 3)


  // 函数是一等公民，就和数字一样。




  // 【官方网站】 https://www.scala-lang.org/

  // 【API 文档】
  // https://docs.scala-lang.org/api/all.html
  // https://www.scala-lang.org/api/current/

  // 【Play FrameWork 官方文档】https://www.playframework.com/documentation/2.8.0-M5/Home
}
