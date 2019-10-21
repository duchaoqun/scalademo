package cn.duchaoqun.Chapter01

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
  val opt1 = map0.get(1)  // Some(Scala)
  val opt2 = map0.get(2)  // None

  // 详解Option[T]
  // 1. 在Scala里Option[T]实际上是一个容器,就像数组或是List一样,你可以把他看成是一个可能有零到一个元素的List.
  // 2. 当你的Option里面有东西的时候,这个List的长度是1(也就是Some),而当你的Option里没有东西的时候,它的长度是0(也就是None).
  opt1.size  // 1
  opt2.size  // 0

  opt1.isEmpty // 返回 "true"
  opt2.isEmpty // 返回 "false"

  // 你可以使用模式匹配来分析这个值（不过这有点繁琐）。
  map0.get(1) match {
    case Some(v) => println(v)
    case None => println("__")
    case _ => println("Null")
  }
  // 还可以使用这种方式，不过这也很繁琐。
  val res3 = map0.get(1)
  if (res3.isEmpty) println("None") else println(res3.get)

  // 最好的方式就是使用 getOrElse ，如果没有取得对应的值，就会返回后面的字符串。
  println(res3.getOrElse("None"))   // Option 对象的方法
  println(map0.getOrElse(1,"None")) // Map 对象本身也有这个方法


  // 如果你想略过 None 对象，可以使用 for 的推导式，如果 get 返回的是 None 对象，什么都不会发生，如果是 Some 对象，就会绑定到变量。
  for ( x <- map0.get(1)) println(x)

  opt1.size
}
