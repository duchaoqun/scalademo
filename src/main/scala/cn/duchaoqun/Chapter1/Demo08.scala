package cn.duchaoqun.Chapter1

object Demo08 extends App {
  // Option 类型的子类型 Some，包装了一些元素，代表有值。
  val v0 = Some("String")

  // Option 类型的子类型 None，表示什么都没有，代表无值。
  val v1 = None

  // 这比使用空字符串意图更加清晰，比使用 null 来表示缺少某值的做法更加安全。

  // Option 支持泛型
  val v2 = Some("Scala") // Option[String] => Some[String]

  // Map 对象的 get【def get(key: K): Option[V]】方法返回一个 Option 类型对象，如果对于给定的 key 没有找到对应的 value，
  // 则返回 None 对象，如果有值，则使用 Some 对象包裹着。
  val map0 = Map(1 -> "Scala")
  val res0 = map0.get(2)
}
