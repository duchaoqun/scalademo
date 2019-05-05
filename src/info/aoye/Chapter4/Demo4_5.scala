package info.aoye.Chapter4

/**
  * 4.5 SortedMap(树形映射)
  * 默认情况下Scala提供的是哈希表，由于对使用的键没有很好的哈希函数，或者需要顺序的访问所有的键，可能会需要一个树形Map
  */
object Demo4_5 extends App {
  val socre0 = scala.collection.immutable.SortedMap("Scala" -> 10, "Java" -> 8, "JS" -> 10)

  // 如果需要按插入顺序访问所有键，使用LinkedHashMap
  val score1 = scala.collection.mutable.LinkedHashMap("Scala" -> 10, "Java" -> 8, "JS" -> 10)
}
