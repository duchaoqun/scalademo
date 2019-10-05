package cn.duchaoqun.Chapter9

import scala.io.Source

/**
  * 9.2 读取字符
  */
object Demo2 extends App {
  val source = Source.fromFile("C:\\Users\\DU\\Desktop\\test.txt", "UTF-8")

  // 要从文件中直接获取字符，可以直接迭代source对象。
  for (x <- source) {
    println(x)
  }
  // 如果你想查看某个字符，但是不处理掉他的话，调用source的buffered方法，这样你就可以用head方法查看下一个字符，但同时并
  // 不把它当作是已处理的字符。
  val iter = source.buffered

  while (iter.hasNext){
    if( iter.head == 'T'){
      println("Find Char T")
    }
    iter.next()
  }

  // 如果你的文件不大，可以直接将所有内容转换成一个字符串来操作。
  val context = iter.mkString
  source.close()
}
