package cn.duchaoqun.Chapter09

import scala.io.Source

object Demo02 extends App {
  val source = Source.fromFile("C:\\Users\\Chris\\Desktop\\New folder\\THUCNews\\THUCNews\\体育\\0.txt", "UTF-8")

  // 要从文件中直接获取字符，可以直接迭代 Source 对象，因为 Source 类扩展自 Iterator[Char] 。
  for (x <- source) {
    // println(x)
  }

  // 如果你想查看某个字符，但是不处理掉他的话，调用 Source 的 buffered 方法，这样你就可以用 head 方法查看下一个字符，但同时并不把它当作是已处理的字符。
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
