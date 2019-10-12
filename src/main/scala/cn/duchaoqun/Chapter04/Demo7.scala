package cn.duchaoqun.Chapter04

import scala.language.postfixOps

/**
  * Tuple
  * 1. 元组是不可变的，但与列表不同的是元组可以包含不同类型的元素（该元组的类型由其保存的内容决定）。
  * 2. 元组中最多只能包含 22 个元素，目前 scala 根包中有tuple1 -> tuple22。
  * 3. 元组的下标是从 1 开始的。
  * 4. 一个重要的作用就是用作函数的返回值，在Tuple中返回若干值。
  * 5. 最常用的是 Tuple2 类型。
  */
object Demo7 extends App {

  // 创建对象
  val tp1 = "Scala"
  val tp2 = Tuple2("Hi", "Scala")
  val tp3 = ("Hi", "Scala", "Scala")
  val tp4 = ('1', "abc", 123, List(1, 2, 3)) // 可以包含任意类型的对象
  val tp5 = (1, 3.14, "Four")                // 类型是： Tuple3[Int, Double, java.lang.String]


  // 访问对象
  // 访问Tuple中的元素，与数组和字符串的下标不同，Tuple从 1 开始
  println(tp5 _1)
  println(tp5._2)
  println(tp5._3)

  // 通常使用匹配来获取元组中的元素
  val (first0, second0, third) = tp5
  val (first1, second1, _) = tp5      // 在不需要的地方使用 _ 替代


  // 最常用的二元组，常与 Map 搭配使用。
  val tp6 = ("key" -> "value")  // 不推荐，多余按键
  val tp7 = ("key", "value")    // 推荐写法
  val tp8 = "key" -> "value"    // 推荐写法
  // 交换两个元素位置，Tuple2 特有方法。
  println(tp8.swap)

  // 迭代tuple元素
  val tuple8 = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
  tuple8.productIterator.foreach(x => println(x))

  println(tuple8.productArity)  // tuple 的参数数量22
  println(tuple8.productPrefix) // 打印前缀Tuple22


  //TODO：Tuple可以用于函数返回不止一个值的情况。
  //TODO： Tuple结构与List结构的优缺点对比？
}
