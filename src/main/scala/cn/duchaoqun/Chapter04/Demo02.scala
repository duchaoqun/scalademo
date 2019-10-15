package cn.duchaoqun.Chapter04

object Demo02 extends App {

  val scores0 = Map("Scala" -> 10, "Java" -> 8)

  // 在Scala中，你可以使用()来查找某个键的值，如果不包含这个键，就会报错 java.util.NoSuchElementException: key not found: Scala1
  println(scores0("Scala"))

  // 在取值之前需要确认是否存在这个 Key
  val scalaScore0 = if (scores0.contains("Scala")) scores0("Scala") else 0

  // 常规写法，获取键为“Scala”的值，如果没有就返回 0。
  val scalaScore1 = scores0.getOrElse("Scala", 0)

  // 返回的 Option 对象的常规操作
  val scalaScore2 = scores0.get("Scala") match {
    case Some(v) => v
    case None => 0
  }
}
