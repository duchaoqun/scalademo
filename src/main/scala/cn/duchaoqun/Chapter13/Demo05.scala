package cn.duchaoqun.Chapter13

import scala.collection.mutable.ListBuffer

object Demo05 extends App {

  case class T5Model(id: Int, name: String)
  val list_1 = List(5,6,7)

  // 创建缓冲区对象,注意泛型
  val list_buffer_1 = new ListBuffer[Int]     // 基本类型的集合
  val list_buffer_2 = new ListBuffer[T5Model] // 对象类型的集合

  // 使用伴生对象的 apply 方法创建对象。
  val list_buffer_3 = ListBuffer(1, 2, 3, 4, 5)

  // 添加一个元素到结尾，返回自身 this
  list_buffer_1 += 1
  list_buffer_1.addOne(2)

  // 添加一个列表到结尾，返回自身 this
  list_buffer_1 ++= list_1
  list_buffer_1.addAll(list_1.iterator)

  // 添加一个元素到开头, 返回 新的 Buffer
  val list_buffer_4 = 3 +: list_buffer_1


  // 转换成其他集合
  val list_2 = list_buffer_1.toList  // 转换为List[Int]对象, 不可变的对象
  val seq_1 = list_buffer_4.toSeq    // 转换为Seq对象

  // 词频统计,字符列表 -> 二元组列表 -> 按照键分组的二维二元组列表 -> 计算字符关键字和数量 -> 然后转换成列表 -> 反转
  // termsList.map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.size)).toList.sortBy(_._2).reverse

}
