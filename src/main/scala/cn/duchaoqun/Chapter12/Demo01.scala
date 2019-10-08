package cn.duchaoqun.Chapter12

object Demo01 extends App {
  // 使用 def 关键字来定义 function
  def functionA:String = {
    // 不推荐使用 return 关键字显示的返回结果。
    // return "Scala"
    // 函数体最后一行表达式的结果就是整个函数的返回结果。
    "Scala"
  }
}
