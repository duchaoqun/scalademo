package cn.duchaoqun.Chapter13

object Demo13_4 extends App {

  // 创建一个空列表对象
  val nil = Nil

  // 创建一个 List[Int] 类型的列表
  val list_1: List[Int] = List(1, 2, 3, 4, 5)

  // 列表有两个形态：
  // 1. 只是一个 Nil 空列表。
  // 2. 一个 head 元素，和一个 tail 列表。（tail 列表也是这么组成的，直到 tail 是 Nil）
  println(list_1.head)
  println(list_1.tail)


  // 操作符 “::” 注意该操作符是右结合的。
  // 1. 指定一个 head 元素为 0 ，tail 列表为 list_1，创建一个新的列表。
  val list_2 = 0 :: list_1
  // 2. 指定所有元素，最后一个是 Nil。
  val list_3 = 0 :: 1 :: 2 :: 3 :: Nil
  val list_4 = (0 :: (1 :: (2 :: (3 :: Nil)))) // 右结合


  // 遍历链表
  // 计算整型链表中所有元素的和
  def sum_1(list: List[Int]): Int = {
    if (list == Nil) 0 else list.head + sum_1(list.tail)
  }

  // 使用模式匹配计算整型链表中所有元素的和
  def sum_2(list: List[Int]): Int = list match {
    case Nil => 0
    case head :: tail => head + sum_2(tail)
  }

  // 使用类库中 sum 方法
  val list_5 = List(1, 2, 3, 4, 5)
  val res1 = list_5.sum


}
