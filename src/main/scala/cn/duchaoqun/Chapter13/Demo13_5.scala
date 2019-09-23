package cn.duchaoqun.Chapter13

import scala.collection.mutable.ListBuffer

/**
  * 2.11.0 以前的版本使用 LinkedList ，和不可变的 List 类似，只不过你可以通过 elem 引用来修改其头部，next 引用来修改其尾部。
  *
  * 2.13.0 使用 ListBuffer
  */
object Demo13_5 extends App {
  val list_1 = ListBuffer(1, 2, 3, 4, 5)

}
