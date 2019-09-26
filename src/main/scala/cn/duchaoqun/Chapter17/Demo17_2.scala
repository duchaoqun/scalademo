package cn.duchaoqun.Chapter17

/**
  * 函数和方法也可以带类型参数
  */
object Demo17_2 extends App {

  // 和泛型类一样，你需要把参数类型放在方法名称后面，Scala会从调用该方法的实际参数类型来推出类型。
  def getMiddle[T](a:Array[T]) = a(a.length / 2)

  val res = getMiddle(Array(1,2,3,4,5))

  // 如果有必要，你可以指定类型：
  val f = getMiddle[String] _
}
