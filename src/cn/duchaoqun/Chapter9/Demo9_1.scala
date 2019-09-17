package cn.duchaoqun.Chapter9

/**
  * 9.1 读取行
  */
object Demo9_1 extends App {
  import scala.io.Source
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
}
