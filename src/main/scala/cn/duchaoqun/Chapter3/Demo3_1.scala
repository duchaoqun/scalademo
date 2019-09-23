package cn.duchaoqun.Chapter3

object Demo3_1 extends App {

  // 如果你需要一个长度不变的数组，可以使用Scala中的Array，必须声明类型(泛型)。

  val array_1 = new Array[Int](10)           // 创建 Int 类型数组，所有元素初始化为0。
  val array_2 = new Array[String](10)        // 创建 String 类型数组，所有元素初始化为null。
  val array_3 = new Array[Float](100)        // 创建 Float 类型数组，默认值是0.0。
  val array_4 = Array("Scala","Java")        // 使用伴生对象的 apply 方法创建长度为 2 的 String 类型数组。
  val array_5 = Array[Int](1, 2, 3)     // 使用半生对象的 apply 方式创建数字数组，给定初始值。
  val array_6 = Array.apply(1, 2, 3, 4, 5)   // 不用声明类型，是因为scala的类型推倒能力。
  val array_7 = Array(1, 2, 3, 4, 5)         // 这里可以去掉泛型，是因为scala的类型推倒能力。


  // 查看，使用 () 来访问数组。
  array_7(0) = 123  // 访问赋值，下标从0开始，到length-1，超过length-1会出现数组越界的错误：ArrayIndexOutOfBoundsException

  // 删除元素，返回新 Array
  val array_8 = array_7.drop(2)      // 从左边删除两个元素
  val array_9 = array_7.dropRight(2) // 从右边删除两个元素

  // 常用方法
  array_7.sum     // 如果包含的元素是数值型，可以计算sum值。
  array_7.indices // Range(0,1,2,3,4,...,n) 获取数组下标Range，从0开始，一般循环的时候使用。
  array_7.size    // 过期：获取array长度
  array_7.length  // 推荐：获取array长度

  // 技巧: 在定义的时候修改默认值
  val array_10 = new Array[Int](100).map(x => 100)
  val array_11 = new Array[String](100).map(x => "-")

  // 遍历 Array
  array_7.foreach(println)
  for (item <- array_7) println(item)                // 遍历数组内元素
  for (item <- 0 until array_7.length) println(item) // 过期：遍历array下标，从0开始。
  for (item <- array_7.indices) println(item)        // 推荐：遍历array下标，从0开始。

  // 简单排序
  scala.util.Sorting.quickSort(array_7) //对数组进行快速排序
  println("quickSort = " + array_7.mkString("###", ",", "###"))

  // 类型转换: 参考 ArrayBuffer 类库(可变的数组)
  val arrayBuffer = array_7.toBuffer



  // Array 与 for 循环中的一些应用 //

  // 对已有的数组，通过对已有的元素进行操作，然后生成一个新的数组，可以使用yield关键字来实现。
  // 1. 他是在不修改已有的 Array 数据元素的基础上实现的，非常适合大数据的处理。
  // 2. Spark 在大数据处理中，业务核心就类似于 yield 通过使用 function 对每个元素进行操作，来构成新的集合(RDD)。
  val array = Array(1,2,3,4,5,6,7,8,9)
  val array1AddOne = for (item <- array) yield item + 1
  println("array1AddOne = " + array1AddOne.mkString("###", ",", "###"))

  // 守卫判断
  val array1AddEven = for (item <- array if item % 2 == 0) yield item
  println("array1AddEven = " + array1AddEven.mkString("######", ",", "######"))



  // Array 中的一些高阶函数 //

  // 集合的filter函数
  println(array.filter(item => item % 2 == 0).mkString(",")) //使用Array的filter函数.
  println(array.filter(_ % 2 == 0).mkString(",")) //使用Array的filter函数.简写方式,使用下划线.

  // 集合的map函数
  println(array.filter(_ % 2 == 0).map(item => item * 10).mkString(",")) //使用Array的map函数.简写方式.
  println(array.filter(_ % 2 == 0).map(_ * 10).mkString(",")) //使用Array的map函数.简写方式,使用下划线.

  // 集合的zipAll函数
  val array2 = Array(4, 5, 6)
  array.zipAll(array2, 0, 0).foreach(println)
  val c = array.zipAll(array2, 0, 0).map(x_w => x_w._1 * x_w._2).sum / 3.toFloat
}
