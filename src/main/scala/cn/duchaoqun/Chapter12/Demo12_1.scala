package cn.duchaoqun.Chapter12

import scala.math.ceil

object Demo12_1 extends App {

  val a: Double = 3.14

  // 将 ceil method 赋值给 func 变量。
  // 正常来讲 ceil 是 math 包里面的一个 method ，我们调用它需要给它传递一个参数，比如：val a = ceil(3.14)。
  // 这里 ceil 后面跟着一个下划线符号(_)，表示将 ceil 变成 function 然后赋值给 func 变量。
  val func = ceil _

  // 用法1： 直接调用，就是正常的调用方法。
  func(a) // 需要注意，func 是一个包含函数的变量，而不是一个固定的函数。

  // 用法2： 作为参数传递给其他方法
  val b = Array(1.23, 2.34, 3.45, 4.56)
  b.map(func)  // map 方法接受一个函数作为参数，将他应用到集合中的每一个元素上，然后返回包含结果的Array

  // 用法3： 直接创建匿名函数，将匿名函数赋值给变量。
  val func1 = (x:Double) => x * 3

}
