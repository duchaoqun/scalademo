package cn.duchaoqun.Test

import java.io.{File, FileWriter}
import scala.io.Source

/**
  * 针对文件的一些操作
  */
object FromFile extends App {

  // Read File // 读取一个文件，返回BufferedSource。
  val file_1 = Source.fromFile("D:\\TestFile\\fall11_urls.txt")  // 直接读取一个文件
  val file_2 = Source.fromFile("D:\\TestFile\\姓氏.txt", "utf-8")  // 制定字符编码打开

  // Return Iterator // 返回一个迭代器
  val linesIterator = file_1.getLines()

  // 转换成一个字符串，如果文件非常大的话，这里会OOM。
  // val fileString = fileBufferedSource.mkString

  println(linesIterator.length)

  var x = 0

  while (linesIterator.hasNext){

  }

  val file = new File("D:\\TestFile\\1.txt")
  val fileWriter = new FileWriter(file, true)


  // 案例：按照行处理数据

//  while (linesIterator.hasNext) {
//    val a = linesIterator.next()
//    val res = Try(a.split("""\|\|\|""")) // 留意split使用的是正则表达式，注意转义
//    res match {
//      case Success(x) => {}
//      case Failure(e) => {}
//    }
//  }

  //TODO scala 的序列化和反序列化?? https://www.jianshu.com/p/080f18900f62
  //TODO 内存序列化? 磁盘序列化? 网络序列化?
}
