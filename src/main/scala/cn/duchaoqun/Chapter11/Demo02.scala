package cn.duchaoqun.Chapter11

object Demo02 extends App {

  // 格式： a 标识符 b  其中标识符是一个“Function”，它有两个参数，一个隐式的参数和一个显示的参数。
  for (x <- 1 to 10) {
    println(x)
  }
  // 上面的 1 to 10 实际上相当于
  1.to(10)

  // 这样的表达式被称作中置（infix）表达式，因为操作符位于两个参数之间。
  // 操作符既可以使用字母（to），也可以使用符号（->）！


  // 自定义操作符：
  class Test(n: Int) {
    val x: Int = n
    def *(other: Test): Int = x * other.x
  }

  val x = new Test(2)
  val y = new Test(4)

  println(x * y)
}


