package cn.duchaoqun.Chapter13

/**
  * 如下是集合的基本继承层级关系，最上层是 Iterable 特质
  *
  *                     Iterable[Trait]
  * Seq[Trait]          Set[Trait]          Map[Trait]
  * IndexedSeq[Trait]   SortedSet[Trait]    SortedMap[Trait]
  *
  * 每个 Scala 集合特质或者类都有一个带有 apply 方法的伴生对象，这个方法可以用来创建该集合的实例。【统一创建原则】
  */
object Demo13_1 extends App {
  // 创建一个 Set 集合
  val set1: Set[Int] = Set(1, 2, 3)

  // 转换成 Iterable 对象
  val iterableSet: Iterator[Int] = set1.iterator

  // 对 Iterable 对象最基本的遍历方法
  while (iterableSet.hasNext){
    println(iterableSet.next())
  }

}
