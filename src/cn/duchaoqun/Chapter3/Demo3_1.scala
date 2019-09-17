package cn.duchaoqun.Chapter3

/**
  * 3.1 定长数组
  */
object Demo3_1 extends App {
  // 如果你需要一个长度不变的数组，可以使用Scala中的Array
  val arr0 = new Array[Int](10)       // 10个整数的数组，所有元素初始化为0
  val arr1 = new Array[String](10)    // 10个字符串的数组，所有元素初始化为null
  val arr2 = Array("Scala","Java")  // 长度为2的String类型数组，已经提供初始值就不需要new，这是Object特性。

  arr2(0) = "Groovy!"  // 使用()来访问数组。

  println(arr2.foreach(println))
}
