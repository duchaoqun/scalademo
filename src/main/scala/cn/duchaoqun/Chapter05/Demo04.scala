package cn.duchaoqun.Chapter05

object Demo04 extends App {

  // 方法可以访问该类的所有对象的私有字段。
  class Counter {
    // 定义私有字段
    private var value = 0

    def increment() {
      value += 1
    }

    // 你可以访问另外一个对象的私有字段。
    def isLess(other: Counter): Boolean = value < other.value

    // 对象私有字段，只有这个对象可以访问，其他对象不能访问这个属性，Scala 不会生成 getter/setter 方法。
    private[this] var value1 = 0
  }

  val c1 = new Counter
  val c2 = new Counter

  c1.increment()

  println(c2.isLess(c1))

}

