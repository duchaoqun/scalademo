package info.aoye.Chapter3

import scala.collection.mutable.ArrayBuffer

/**
  * 3.5 常用算法
  */
object Demo3_5 extends App {
  val a = Array(1, 2, 3, 4, 5, 4)
  a.sum // 求数组元素的和，要求必须是数值类型
  a.min
  a.max

  // 使用工具类可以直接对一个数组进行排序，从小到大
  scala.util.Sorting.quickSort(a)

  println(a.mkString(" and ")) // 转换成字符串，中间添加and字符串 => 1 and 2 and 3 and 4 and 4 and 5
  println(a.mkString("<",",",">")) // 指定前缀和后缀  => <1,2,3,4,4,5>

}
