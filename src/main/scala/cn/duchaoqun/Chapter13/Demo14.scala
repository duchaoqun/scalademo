package cn.duchaoqun.Chapter13

import scala.collection.immutable.Queue

object Demo14 extends App {
  // 创建一个不可变的队列
  val queue1 = Queue[Int]()

  // 添加一个元素,返回新值. Queue(1)
  val queue2 = queue1.enqueue(1)

  // 添加多个元素,可以直接传入List对象给enqueue方法 注意:可变的Queue与此不同,会将整个List对象作为元素插入Queue
  val queue3 = queue2.enqueue(List(1,2,3))  //Queue(1, 1, 2, 3)

  // 取出元素
  // 注意：返回由队列头部元素和移除该元素之后的剩余队列组成的对偶（Tuple2）
  val tuple1 = queue3.dequeue  //(1,Queue(1, 2, 3))


  println(tuple1)
}
