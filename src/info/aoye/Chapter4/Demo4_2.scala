package info.aoye.Chapter4

/**
  * 4.2 获取Map中的值
  */
object Demo4_2 extends App {
  val scores0 = Map("Scala" -> 10, "Java" -> 8)

  // 在Scala中，Function和Map有些相似，你可以使用()来查找某个键的值，如果不包含这个键，就会报错 java.util.NoSuchElementException: key not found: Scala1
  println(scores0("Scala"))
  // 在取值之前需要确认是否存在这个Key
  val scalaScore0 = if (scores0.contains("Scala")) scores0("Scala") else 0
  val scalaScore1 = scores0.getOrElse("Scala",0) // 常规写法

  val scalaScore2 = scores0.get("Scala") // 返回Option对象
}
