package cn.duchaoqun.Chapter17

object Demo09 extends App {

  class Person {}

  class Student extends Person {}

  class Pair1[T](val first: T, val second: T)

  // 假设我们有一个函数对 Pair[Person] 做某种处理：
  def makeFriends(p: Pair1[Person]) {}

  val p1 = new Person
  val p2 = new Student
  val p3 = new Student
  val pair1 = new Pair1[Student](p2, p3)

  // 如果 Student 是 Person 的子类，那么我们可以使用 Pair[Student] 作为参数来调用 makeFriends 吗？
  // makeFriends(pair1) 默认情况下，这是错误的。

  // 如果你想要这样的关系，则必须在定义 Pair 类时说明这一点。
  class Pair2[+T](val first: T, val second: T)

  def makeFriends(p: Pair2[Person]) {}

  val pair2 = new Pair2[Student](p2, p3)
  makeFriends(pair2)

  // +T 表示该类型与 T 是协变的，也就是说，他与 T 按照同样的方向型变。
  // 由于 Student 是 Person 的子类型，Pair2[Student] 也就是 Pair2[Person] 的子类型了。


  // 也可以有另一个方向的型变，就是逆变。
}
