package cn.duchaoqun.Chapter12

object Demo26 extends App {

  def until(condition: => Boolean)(block: => Unit): Unit ={
    if (!condition){
      block
      until(condition){block}
    }
  }

  def indexOf(str: String, char: Char): Int = {
    var i = 0
    until(i == str.length){
      if (str(i) == char) return i
      i += 1
    }
    return -1
  }

  // 在这里，匿名函数
  // {
  //   if (str(i) == char) return i
  //   i += 1
  // }
  // 被传递给 until
  // 当 return 表达式被执行时，包含他的带名函数 indexOf 终止并返回给定的值。
  // 如果你要在带名函数中使用 return 的话，则需要给出其返回类型。举例来说，在上面的 indexOf 函数中，编译器没有办法推断出
  // 它会返回 Int 类型。
  // 控制流程的实现依赖一个在匿名函数的 return 表达式中抛出的特殊异常，该异常从 until 函数传出，并被 indexOf 函数捕获。

  // 注意： 如果异常在被送往带名函数值前，在一个try代码块中被捕获掉了，那么相应的值就不会被返回。
}
