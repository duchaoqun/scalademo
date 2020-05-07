package cn.duchaoqun.Demo

import scala.collection.mutable.ListBuffer

object Demo008 extends App {

  case class T5Model(id: Int, name: String)
  val list_1 = List(5,6,7)

  // 创建缓冲区对象,注意泛型
  val listBuffer1 = new ListBuffer[Int]     // 基本类型的集合
  val list_buffer_2 = new ListBuffer[T5Model] // 对象类型的集合

  // 使用伴生对象的 apply 方法创建对象。
  val list_buffer_3 = ListBuffer(1, 2, 3, 4, 5)

  listBuffer1 += 1        // 添加一个元素到结尾，返回自身 this
  listBuffer1.addOne(2)   // 添加一个元素到结尾，返回自身 this
  listBuffer1.take(2)     // 从开始位置取出指定个数的元素返回新的 listBuffer 对象，原来对象不变。
  listBuffer1.remove(0)   // 移除指定位置的元素，下标为0，改变原来的对象。

  // 添加一个列表到结尾，返回自身 this
  listBuffer1 ++= list_1
  listBuffer1.addAll(list_1.iterator)

  // 添加一个元素到开头, 返回 新的 Buffer
  val list_buffer_4 = 3 +: listBuffer1

  // 转换成其他集合
  val list_2 = listBuffer1.toList  // 转换为List[Int]对象, 不可变的对象
  val seq_1 = list_buffer_4.toSeq    // 转换为Seq对象

  // 词频统计,字符列表 -> 二元组列表 -> 按照键分组的二维二元组列表 -> 计算字符关键字和数量 -> 然后转换成列表 -> 反转
  // termsList.map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2).reverse
}
