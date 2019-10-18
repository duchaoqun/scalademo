package cn.duchaoqun.Chapter13

object Demo01 extends App {
  // 创建一个 Set 集合
  val set1: Set[Int] = Set(1, 2, 3)

  // 转换成 Iterable 对象
  val iterableSet: Iterator[Int] = set1.iterator

  // 对 Iterable 对象最基本的遍历方法，这是遍历集合最基本的方式。
  while (iterableSet.hasNext){
    println(iterableSet.next())
  }

}
