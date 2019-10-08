package cn.duchaoqun.Chapter12

object Demo12 extends App {


  // 知识点：你可以在任何作用域中定义函数：包、类、另外一个函数。
  // 知识点：在函数体内，你可以访问到相应作用域中的任何变量。(你的函数可以在变量不再处于作用域内时被调用)
  def mulBy(factor: Double) = (x: Double) => factor * x

  // 开始如下调用：
  val triple = mulBy(3)
  val half = mulBy(0.5)

  println(triple(14) + " " + half(14))

  // 1. mulBy 第一次被调用的时候， factor 被设置成 3 ，该变量在(x: Double) => factor * x 函数体内被引用。
  // 2. 该函数被存入 triple ，然后参数变量 factor 从运行时的栈上被弹出。
  // 3. mulBy 第二次被调用，factor 被设置成 0.5 ，该变量在(x: Double) => factor * x 函数体内被引用。
  // 4. 该函数被存入 half

  // 每一个返回的函数都有自己的 factor 设置。
  // 这样的函数被称作闭包(closure)，闭包由代码和代码用到的任何非局部变量定义构成。
}
