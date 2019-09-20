package cn.duchaoqun.Chapter12

object Demo12_3 extends App {

  // 定义一个函数，计算乘方
  def func1 = (x: Double) => x * x

  // 定义一个“接受函数参数”的函数，这个就是高阶函数（higher-order function）
  // 计算“参数函数”在 0.25 的时候的返回值
  def valueAtOneQuarter(f: Double => Double) = f(0.25)
  // 知识点：高阶函数的类型是：{(Double) => Double } => Double



  // 定义一个“返回结果是函数”的函数。
  def mulBy(factor: Double) = (x: Double) => factor * x
  // mulBy(3) 返回的是 (x: Double) => 3 * x
  val quintuple = mulBy(5)
  // 知识点：此高级函数的类型是 Double => {(Double) => Double }

}
