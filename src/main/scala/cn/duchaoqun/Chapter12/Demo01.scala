package cn.duchaoqun.Chapter12

object Demo01 extends App {

  // 使用 def 关键字来定义无参数列表的 method
  def methodA: String = {
    // 不推荐使用 return 关键字显示的返回结果。
    // return "Scala"
    // 函数体最后一行表达式的结果就是整个函数的返回结果，不要使用 return 语句。
    "Scala"
  }

  // 要点：Function 必须有参数列表（可以为空）。
  // 使用 val 关键字来定义一个无参函数。
  val functionA = () => println("Scala")

  // 使用 val 关键字来定义一个有参 Function。
  val functionB = (x: Int) => x * x

  // 要点：调用没有参数列表的方法的时候，可以省略小括号。
  methodA
  // 要点：调用没有参数的函数的时候，需要携带小括号。
  functionA()
}
