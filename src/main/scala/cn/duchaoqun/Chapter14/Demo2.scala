package cn.duchaoqun.Chapter14


/**
  * 2. 使用守卫的 match case 表达式
  */
object Demo2 extends App {
  var sign = 0
  var digit = 0
  val ch = 8

  // 守卫可以是任何的 Boolean 类型表达式
  // 注意模式匹配总是从上向下进行匹配，如果携带守卫的这个分支不能匹配，就会使用默认匹配。
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }

  println(sign + ":" + digit)
}
