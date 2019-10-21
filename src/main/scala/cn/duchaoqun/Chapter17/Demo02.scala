package cn.duchaoqun.Chapter17

object Demo02 extends App {

  // 和泛型类一样，你需要把参数类型放在方法名称后面，Scala会从调用该方法的实际参数类型来推出类型。
  def getMiddle[T](a: Array[T]) = a(a.length / 2)

  val res = getMiddle(Array(1, 2, 3, 4, 5))

  // 如果有必要，你可以指定类型：
  val f = getMiddle[String] _

  /**
    * 使用【类型参数】的函数
    *
    * @param array 函数的参数，它的类型是Array[T]
    * @tparam T 类型参数，用来界定参数中 Array 所包含元素的类型
    * @return 将 Array[T] 类型转换成 List[T] 类型
    */
  def asList[T](array: Array[T]): List[T] = {
    if (array == null || array.isEmpty) {
      List[T]()
    } else {
      array.toList
    }
  }
}
