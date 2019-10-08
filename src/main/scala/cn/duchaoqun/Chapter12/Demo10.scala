package cn.duchaoqun.Chapter12

object Demo10 extends App {

  // 定义一个接收“函数参数”的函数，显示的声明了“函数参数”的类型。
  def valueAtOneQuarter(f: Double => Double) = f(0.25)

  // 传递进去一个匿名函数
  valueAtOneQuarter((x: Double) => x * 3)

  // 匿名函数的参数类型可以去掉，Scala 会推断出这个高阶函数的参数类型。
  valueAtOneQuarter((x) => x * 3)

  // 对于只有一个参数的匿名函数，可以省略外面的小括号。
  valueAtOneQuarter(x => x * 3)

  // 如果参数在 => 右边仅出现了一次，可以使用下划线来替代。
  valueAtOneQuarter( _ * 3)

}
