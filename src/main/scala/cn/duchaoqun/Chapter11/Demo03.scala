package cn.duchaoqun.Chapter11

import scala.language.postfixOps

object Demo03 extends App {

  // + - ! ~ 都可以作为前置(prefix)操作符，出现在参数之前。
  // 它们被转换成对名为“unary_操作符”的方法调用。
  val a = 1

  // 如下两个的结果是一样的。
  println(-a)
  println(a.unary_-)

  // 如果某一个一元操作符跟在参数后面，它就是后置(postfix)操作符号。
  println(a.toString)
  println(a toString)

  // 后置操作符可能会引发解析错误。
  val result = 100 toString
  // println(result)
  // 这里就会提示错误：Too many arguments for method toString!
  // 由于解析优先级高于类型推断和重载判定，编译器在这个时候并不知道 toString 是一个一元方法。
  // val result = 42.toString(println(result))
  // 因此，如果你使用后置操作符，编译器就会向你发出警告。
  // 你可以使用编译器选项 -llanguage:postfixOps 来关闭这个警告，或者在源代码中添加
  // import scala.language.postfixOps
}
