package info.aoye.Chapter4

/**
  * 4.7 Tuple
  * Map是键值对的集合
  * 最简单的Tuple就是一个键值对。
  * Tuple是不同类型的元素的集合。
  */
object Demo4_7 extends App {
  // 定义一个Tuple，类型是： Tuple3[Int, Double, java.lang.String]
  val tp0 = (1, 3.14, "Four")

  // 访问Tuple中的元素，与数组和字符串的下标不同，Tuple从 1 开始
  println(tp0 _1) // 可以写成这样
  println(tp0._2)
  println(tp0._3)

  // 通常使用匹配来获取元组中的元素
  val (first0, second0, third) = tp0
  val (first1, second1, _) = tp0  // 在不需要的地方使用 _ 替代

  //TODO：Tuple可以用于函数返回不止一个值的情况。
}
