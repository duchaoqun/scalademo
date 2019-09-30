package cn.duchaoqun.Chapter14

/**
  * 1. match case 表达式
  */
object Demo1 extends App {
  var sign = 0
  val ch:Char ='S'

  // case _ 默认匹配，如果没找到匹配的内容，就执行这部分代码（避免匹配不到而报MatchError）。
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ => sign = 0
  }

  // 与 if 表达式类似，match 也是表达式，而不是语句，所以可以简化成如下形式。
  sign = ch match {
    case '+' => 1
    case '-' => -1
    case _ => 0
  }

  // 你可以在 match 表达式中使用任何类型，而不仅仅是数字。
}
