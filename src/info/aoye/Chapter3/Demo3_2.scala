package info.aoye.Chapter3

/**
  * 3.2 变长数组：数组缓冲
  * 对于那种长度需要变化的数组，Java有ArrayList，C++有vector，Scala中等效的数据结构是ArrayBuffer
  */
object Demo3_2 extends App {

  import scala.collection.mutable.ArrayBuffer

  // 定义一个空的缓冲数组，准备存放整数
  val b1 = ArrayBuffer[Int]()
  val b2 = new ArrayBuffer[Int]

  b1 += 1               // 使用+=在缓冲数组后面添加一个元素ArrayBuffer(1)
  b1 += (2, 3, 4, 5)    // 在尾部添加多个元素，使用()括起来。
  b1 ++= Array(6, 7, 8) // 使用++= 来添加任何其他的集合

  b1.trimStart(2) // 删除前面两个元素
  b1.trimEnd(2)   // 删除后面两个元素
  //Note： 在缓冲数组尾端添加和移除元素是一个非常高效的操作。 amortized constant time

  //你也可以在任意位置插入或者移除元素，但这样的操作并不那么高效（所有在那个位置之后的元素都必须被平移）。
  b1.insert(2, 6)        // 在下标是 2 的位置插入6，其他元素向后移动
  b1.remove(2)           // 移除下标是 2 的元素，其他元素前移
  b1.remove(2, 3)        // 从下标 2 开始，移除 3 个元素

  // 有时候你需要定义一个Array，但不知道最终需要装多少个元素，可以先创建一个缓冲数组，然后调用toArray，相反的，Array也可以调用toBuffer转换成缓冲数组。
  b1.toArray
}
