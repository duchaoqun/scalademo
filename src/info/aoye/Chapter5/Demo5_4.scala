package info.aoye.Chapter5

/**
  * 5.4 对象私有字段
  */
object Demo5_4 extends App {
  // 方法可以访问该类的所有对象的私有字段。
}

class Counter1 {
  private var value = 0
  def increment() {value += 1}
  def isLess(other:Counter1): Boolean = value < other.value  // 你可以访问另外一个对象的私有字段。

  private[this] var value1 = 0 // 对象私有字段，只有这个对象可以访问，其他对象不能访问这个属性。
}