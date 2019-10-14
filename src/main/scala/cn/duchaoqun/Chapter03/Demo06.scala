package cn.duchaoqun.Chapter03

import scala.collection.mutable.ArrayBuffer

/**
  * 3.6 解读ScalaDoc
  *
  */
object Demo06 extends App {

  val a = ArrayBuffer(1, 2, 3)
  a.append(4, 5, 6) // 追加元素到缓冲数组，注意这里是缓冲数组，不是数组
  println(a.toList)

  val b = Array(7, 8, 9)
  a.appendAll(b) // 追加另外一个同类型的元素。
  println(a.toList)

  println(a.count(_ > 2)) // 统计满足条件的元素的个数
  //TODO: def count(p: A => Boolean): Int  思考: p是一个偏函数？ count接受一个函数作为参数，这个函数接收并处理类型为A的数据，返回一个Boolean类型值

  val c = ArrayBuffer(1,2,3)
  c += 4 // 追加一个元素，返回的是this
  println(c)
  //TODO: def +=(elem: A): this.type


}
