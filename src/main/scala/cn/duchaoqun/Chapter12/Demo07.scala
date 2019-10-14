package cn.duchaoqun.Chapter12

/**
  * 函数可以直接作为参数传递给函数，这极大的简化了编程的语法。
  * 以前 Java 的方式是 new 一个接口实例，并在接口实例的回调方法 callback 来实现业务逻辑，现在直接把回调方法 callback 传递给我们的函数，且在函数体中直接使用，这毫无疑问的简化了代码的编写，提升了开发效率。
  * 这种方式非常方便编写复杂的业务逻辑和控制逻辑，对于机器学习、深度学习、图计算等而言至关重要。
  */
object Demo07 extends App {
  val list1 = List(1, 2, 3, 4, 5, 6)
  // 官方 List 类库的 foreach 函数

  // 定义一个 Function 用来作为参数，当然这里只能操作 Int 类型的元素，List 可以容纳各种类型。
  val func0 = (x: Int) => println(x)

  // 使用泛型，更好的写法？ // TODO 函数如何使用泛型？
  def f1[T](x: T): Unit = {
    println(x)
  }

  list1.foreach(x => println(x)) // 使用匿名函数
  list1.foreach(func0) // 使用我们定义的函数
  list1.foreach(f1(_)) // 使用我们定义的函数


  // 定义一个 Function ，计算乘方
  val func1 = (x: Double) => x * x

  // TODO def 定义的是函数还是方法？ 如何使用 val 来定义高价函数。
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
