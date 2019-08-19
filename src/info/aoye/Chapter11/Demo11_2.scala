package info.aoye.Chapter11

/**
  * 11.2 中置操作符
  */
object Demo11_2 extends App {
  // 格式： a 标识符 b  其中标识符是一个“Function”，它有两个参数，一个隐式的参数和一个显示的参数。

  // e.g.
  for (x <- 1 to 10) { println(x) }
  // 上面的 1 to 10 实际上相当于
  1.to(10)
  // 这样的表达式被称作中指（）表达式，因为操作符位于两个参数之间。
  // 操作符既可以使用字母（to），也可以使用符号（->）！
}

// 自定义操作符：
//class Fraction(n:Int, d:Int){
//  private val num = ...
//  private val den = ...
//    ...
//  def *(other:Fraction) = new Fraction(num * other.num , den * other.den)
//}
