package info.aoye.Chapter2

/**
  * 2.7 函数（function）
  *
  * 方法是对对象进行操作，函数不是，相当于一个静态方法。
  */
object Demo2_7 extends App {

  // 定义一个函数，你需要提供函数名称，参数，函数体。
  def abs(x:Double) = if ( x>= 0 ) x else -x

  // 定义一个函数，对于递归函数，我们必须指定返回类型，如果没有返回值类型，编译器不知道n * fac(n - 1)返回类型。
  def fac(n:Int):Int = if (n <= 0 ) 1 else n * fac(n - 1)
}
