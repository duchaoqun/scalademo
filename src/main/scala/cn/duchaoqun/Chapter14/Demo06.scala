package cn.duchaoqun.Chapter14

object Demo06 extends App {
  val array = Array(0, 1, 2, 3, 4, 5)
  val res1 = array match {
    case Array(0) => "0" // 匹配包含 0 的数组
    case Array(x: Any, y: Any) => x + " " + y // 匹配包含两个任意元素的数组。
    case Array(0, _*) => "0 ..." // 匹配任何以 0 开始的数组。
    case _ => "Something else!" // 匹配其他内容。
  }

  // Array 这个伴生对象本身就携带 unapplySeq 提取器方法。
  val res2 = Array.unapplySeq(array) // 实际上调用的就是这个提取器。


  // 正则表达式是另外一个适合使用提取器的场景，如果正则表达式有分组，你可以用提取器来匹配每个分组。
  // 请注意，这里的提取器不是伴生对象，这是一个正则表达式对象。
  val pattern1 = "([0-9]+) ([a-z]+)".r
  "99 bottles" match {
    case pattern1(num, item) => println(num)
  }
}
