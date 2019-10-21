package cn.duchaoqun.Chapter12

object Demo29 extends App {
  // 被包在花括号内的一组 case 语句是一个偏函数（一个并非对所有输入值都有定义的函数）。

  // 它是 PartialFunction[A, B] 类的一个实例，A 是参数类型，B 是返回类型。

  // 该类有两个方法：
  // apply 方法从匹配到的模式计算函数值，而 isDefinedAt 方法在输入至少匹配其中一个模式时返回 true。

  val pf: PartialFunction[Char, Int] = {
    case '+' => 1
    case '-' => -1
  }

  println(pf('-')) // -1
  println(pf.isDefinedAt(0)) // false
  //println(f(0))              // Exception in thread "main" scala.MatchError

  // 有些方法接受 PartialFunction 作为参数。
  // 例如 GenTraversable 特质的 collect 方法将一个偏函数应用到所有在该偏函数有定义的元素，并返回包含这些结果的序列。
  "-3+4".collect {
    case '+' => 1
    case '-' => -1
  } // Vector(-1,1

  // 偏函数表达式必须位于编译器可以推断出返回类型的上下文中，当你把它赋值给一个带有类型声明的变量，或者将他作为参数传递时，都符合这个要求。
}
