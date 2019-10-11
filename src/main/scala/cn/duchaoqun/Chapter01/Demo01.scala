package cn.duchaoqun.Chapter01

object Demo01 extends App {

  // 每个表达式都有一个类型，例如 “val x = 1” 这个表达式就是Int类型。
  val x = 1

  // 条件表达式 if 是有返回值的，可以把他的值赋给一个对象。
  val res1 = if (x < 1) 1 else 0

  // () 表示Unit 对象，代表什么都没有。
  val a: Unit = ()

  // 每个 Scala 集合特质或者类都有一个带有 apply 方法的伴生对象，这个方法可以用来创建该集合的实例。【统一创建原则】
  val set1 = Set(1, 2, 3)


  // 函数是一等公民，就和数字一样。


  // 处理异常的时候使用 throw 表达式，该表达式的返回值类型是 Nothing。
  // 在条件表达式 if 中，如果一个分支的类型是Nothing，那么if/else表达式的类型就是另外一个分支的类型。

  // 调用无参方法可以省略小括号，但是对于调用可以改变对象状态的方法一般写上小括号。
  "Scala".toString

  // 【官方网站】
  // https://www.scala-lang.org/

  // 【官方文档】
  // https://www.scala-lang.org/api/current/    当前最新版本的API文档
  // https://docs.scala-lang.org/api/all.html   各个版本的API文档
  // https://docs.scala-lang.org/tutorials/

  // 【AKKA】
  // https://doc.akka.io/api/akka/2.5.11/akka/index.html

  // 【Play FrameWork 官方文档】
  // https://www.playframework.com/documentation/2.7.x/Home
  // https://www.playframework.com/documentation/2.8.0-M5/Home

  // 【PlaySlick文档】
  // http://slick.lightbend.com/doc/3.2.3/
  // http://slick.lightbend.com/doc/3.2.3/api/index.html#package

  // 【Spark官方文档】
  // http://spark.apache.org/docs/
  // http://spark.apache.org/docs/latest/api/scala/index.html

  // 【其他文档】
  // https://www.scala-js.org/api/scalajs-library/latest/
}
