package cn.duchaoqun.Chapter13

/**
  * 如下是常用的不可变的序列
  *
  * Seq[trait]
  * IndexedSeq[trait]    List  Stream  Stack Queue
  * Vector     Range
  *
  *
  * 如下是常用的可变的序列
  *
  * Seq[trait]
  * IndexedSeq[trait]   Stack  Queue  PriorityQueue  LinkedList  DoubleLinkedList
  * ArrayBuffer
  */
object Demo13_3 extends App {
  // Vector 是 ArrayBuffer 的不可变版本： 一个带下标的序列，支持快速的随机访问。

  // 向量是以树形结构的形式实现的，每个节点可以有不超过 32 个子节点。 对于一个有 100 万个元素的向量来说，我们只需要四层节点。访问这样一个
  // 列表中的某个元素只需要 4 跳，而在链表中，同样的操作需要 500000跳。

  // Range 表示一个整数数列，比如 “0、1、2、3、4、5” 和 “10、20、30”，Range 对象并不存储所有的值，它仅存储“开始、结束、增值”。
  // 可以使用 to 和 until 来创建 Range 对象。
}
