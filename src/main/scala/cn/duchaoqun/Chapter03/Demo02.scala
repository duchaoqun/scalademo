package cn.duchaoqun.Chapter03

object Demo02 extends App {

  import scala.collection.mutable.ArrayBuffer

  // 定义一个空的 ArrayBuffer 准备存放整数，如下是等效的。
  val arrayBuffer1 = ArrayBuffer[Int]()
  val arrayBuffer2 = new ArrayBuffer[Int]

  // 添加一个元素
  arrayBuffer1 += 1      // 使用 += 方法。
  arrayBuffer1.addOne(1) // 使用 addONe 方法。
  // 添加多个元素
  arrayBuffer1 += (2, 3, 4, 5)          // 过期。
  arrayBuffer1 ++= Array(6, 7, 8)       // 使用 ++= 来添加任何其他的集合。
  arrayBuffer1.addAll(Array(7, 8, 9))   // 使用 addAll 添加其他集合。
  // 去掉元素
  arrayBuffer1.trimStart(2) // 删除前面两个元素
  arrayBuffer1.trimEnd(2)   // 删除后面两个元素

  // 你也可以在任意位置插入或者移除元素，但这样的操作并不那么高效（所有在那个位置之后的元素都必须被平移）。
  arrayBuffer1.insert(2, 6) // 在下标是 2 的位置插入6，其他元素向后移动
  arrayBuffer1.remove(2) // 移除下标是 2 的元素，其他元素前移
  arrayBuffer1.remove(2, 3) // 从下标 2 开始，移除 3 个元素

  // 有时候你需要定义一个Array，但不知道最终需要装多少个元素，可以先创建一个缓冲数组，然后调用toArray，相反的，Array也可以调用toBuffer转换成缓冲数组。
  arrayBuffer1.toArray

  // 一些方法
  arrayBuffer1.sum // 计算集合元素内的和.
  arrayBuffer1.max // 计算集合元素内最大值.
}
