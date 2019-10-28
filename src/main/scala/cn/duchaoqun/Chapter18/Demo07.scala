package cn.duchaoqun.Chapter18

object Demo07 extends App {

  // 中置类型是一个带有两个类型参数的类型，以“中置”语法表示，类型名称写在两个类型参数之间。
  val scores1: String Map Int = Map("Fred" -> 42, "Alice" -> 32, "Bob" -> 14)
  val scores2: Map[String, Int] = Map("Fred" -> 42, "Alice" -> 32, "Bob" -> 14)

  // 类似数学中的表达方式，但是感觉不太习惯。
}
