package cn.duchaoqun.Chapter13

object Demo24 extends App {

  // 创建一个迭代器对象
  val iterator = Iterator("Scala", "Spark", "Java", "Hadoop", "Hadoop")

  // 最常用的就是使用while来访问内容
  while (iterator.hasNext) { // 调用it.hasNext()用于检测集合中是否还有元素。
    println(iterator.next) // 调用it.next()会返回迭代器的下一个元素，并且更新迭代器的状态。
  }

  // iterator 只能迭代一次，然后就没有了！！
  iterator.min // 从iterator中查找最小值
  iterator.max // 从iterator中查找最大值
  iterator.size //  查看大小
  iterator.length //  查看大小，调用size
}
