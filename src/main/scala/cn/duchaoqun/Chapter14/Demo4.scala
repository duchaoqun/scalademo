package cn.duchaoqun.Chapter14

/**
  * 4. match case 匹配类型【L2】
  */
object Demo4 extends App {

  // 你可以对表达式的类型进行匹配

  val obj = "2147483640"

  // 在 Scala 中，我们更倾向去使用这种 match case 语句，而不是 isInstanceOf 操作符。
  def textMatch(obj: Any) ={
    obj match {
      case x: Int => x  // 匹配到的 Int 类型值被赋值到变量 x
      case s: String => Integer.parseInt(s)  // 匹配到的 String 类型值被赋值到变量 s
      case _: BigInt => Int.MaxValue  // 匹配任何类型为 BigInt 的对象。
      case BigInt =>   // 匹配类型为 Class 的 BigInt 对象，注意！不应该这样写，你必须给出一个变量名。
      case _ =>
    }
  }

  // 注意：match 发生在 runtime 期间，Jvm 中的泛型信息是被清除的，因此不能使用 match 来匹配特定的 Map 类型。

  val map = Map(1 -> "Scala")

  map match {
    case m: Map[Int, String] => println(m) // todo 这样做是错误的？ 为什么？
    case m: Map[_, _] => println(m)  // todo 这样做是对的？ 为什么？
  }

  println(textMatch(obj))
  println(Integer.MAX_VALUE)
  // 需要是字符串类型的数字
  //println(Integer.parseInt("25000"))

}
