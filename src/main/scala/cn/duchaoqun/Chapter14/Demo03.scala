package cn.duchaoqun.Chapter14

object Demo03 extends App {
  var sign = 0
  var digit = 0
  val str = "Scala"

  str(1) match {
    case '+' => sign = 1
    case '-' => sign = 1
      // 如果 case 关键字后面跟着一个变量名，那么匹配的内容会赋值给这个变量，你可以在守卫中使用这个变量。
    case ch if Character.isDigit(ch) => digit = Character.digit(ch, 10)
      // 默认匹配的分支，你可以理解将变量赋值给【_】。
    case _ => println("No Match")
  }


  // 注意：变量模式可能会与常量表达式冲突：
  import scala.math._
  val x = 3.14

  x match {
      // 这里的 Pi 是常量，并不是将 x 赋值给变量 Pi
      // Scala 是如何知道这个是常量而不是变量呢？
      // 规则是：变量必须以小写字母开头，如果你有一个以小写字母开头的常量(不推荐的写法)，则需要将它包含在反引号中。
    case Pi => println(Pi)
    case _ => println(x)
  }
}
