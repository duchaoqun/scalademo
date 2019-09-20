package cn.duchaoqun.Chapter12

object Demo12_2 extends App {
  val a = Array(1.23, 2.34, 3.45, 4.56)

  // 创建一个匿名函数，并将它赋值给一个变量。
  val func1 = (x: Double) => x * x
  def func3 = (x: Double) => x * x

  // 与 func1 功能相同的方法。
  def func2(x: Double): Double = {
    x * x
  }

  // 用法1：在需要函数参数的地方可以直接创建匿名函数。
  a.map(x => x * x)
  a map (x => x * x)

  // 知识点：函数的类型是这样的 Double => Double 接受 Double 类型，返回 Double 类型，当然可以不显示的写出来。
  // 知识点：map 函数的参数是一个函数，参数类型是提示的是 (f: A => B)， A 是当前集合所包含元素的类型，B 是函数参数计算返回的类型。
  // 知识点：map 这里可以使用中置操作符，但我还是习惯使用点号的方式来调用，毕竟多了一次按键。
}
