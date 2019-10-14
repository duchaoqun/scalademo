package cn.duchaoqun.Chapter02

object Demo11 extends App {

  // 在定义的时候就会读取这个文件
  val words_0 = scala.io.Source.fromFile("FilePath").mkString

  // 在第一次调用的时候读取这个文件
  lazy val words_1 = scala.io.Source.fromFile("FilePath").mkString

  // 每一次调用都会读取这个文件
  def words_2 = scala.io.Source.fromFile("FilePath").mkString
}
