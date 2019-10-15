package cn.duchaoqun.Chapter04

object Demo05 extends App {
  // 需要按照键排序的 Map
  val socre0 = scala.collection.immutable.SortedMap(1 -> "Scala", 3 -> "Java", 2 -> "JS")
  socre0.foreach(println)

  // 如果需要按插入顺序访问所有键，使用LinkedHashMap
  val score1 = scala.collection.mutable.LinkedHashMap("Scala" -> 10, "Java" -> 8, "JS" -> 10)
  score1.foreach(println)
}
