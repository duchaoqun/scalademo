package cn.duchaoqun.Chapter2

/**
  * 2.11 懒值
  * 当val被声明为lazy时，它的初始化过程会被推迟，直到我们首次对他取值。
  * 1. lazy对于开销比较大的初始化语句非常有用。
  * 2. 可以把lazy当作是介于val和def的中间状态。
  */
object Demo2_11 extends App {

  // 在定义的时候就会读取这个文件
  val words_0 = scala.io.Source.fromFile("FilePath").mkString

  // 在第一次调用的时候读取这个文件
  lazy val words_1 = scala.io.Source.fromFile("FilePath").mkString

  // 每一次调用都会读取这个文件
  def words_2 = scala.io.Source.fromFile("FilePath").mkString
}
