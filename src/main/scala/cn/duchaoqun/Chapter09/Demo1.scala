package cn.duchaoqun.Chapter09

import java.io.{File, FileWriter}

/**
  * 9.1 读取行
  */
object Demo1 extends App {
  import scala.io.Source
  // Read File // 读取一个文件，返回BufferedSource。
  // 第一个参数是字符串或者是java.io.File
  // 第二个参数是文件的字符编码
  val source = Source.fromFile("C:\\Users\\DU\\Desktop\\test.txt", "UTF-8")
  // 获取文件中的所有行，结果是一个迭代器
  val lineIterator = source.getLines()
  for ( x <- lineIterator) println(x)

  // 将所有行的数据放置到数组中
  val lines = source.getLines().toArray

  // 把整个文件读取成一个字符串
  val contexts = source.mkString

  // 再取完文件之后需要关闭文件
  source.close

  // 转换成一个字符串，如果文件非常大的话，这里会OOM。
  // val fileString = fileBufferedSource.mkString

  // 写入文件
  val file = new File("D:\\TestFile\\1.txt")
  val fileWriter = new FileWriter(file, true)

  for ( x <- 1 to 100000){
    fileWriter.write(lineIterator.next() + System.getProperty("line.separator"))
  }
  fileWriter.close()


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

  // 获取网页内容
  val html = Source.fromURL("https://www.baidu.com/") // 返回BufferedSource

}
