package cn.duchaoqun.Chapter17

object Demo17_3 extends App {

  // 有时，你需要对类型变量进行限制，例如下面的Pair类型，它要求它的两个组件类型相同
  class Pair1[T](first: T, second: T) {}

  // 现在你想添加一个方法，产出比较小的那个值：
  class Pair2[T](first: T, second: T) {
    //def smaller = if(first.compareTo(second) < 0) first else second // 这个方法是错误的，我们不知道 first 有 compareTO方法。
  }

  // 要解决上面的问题，我们可以添加一个上界：
  class Pair3[T <: Comparable[T]](first: T, second: T) {
    def smaller: T = if (first.compareTo(second) < 0) first else second
  }

  // T <: Comparable[T] 说明 T 必须是 Comparable[T] 的子类型

  // 这样我们就可以实例化 String 类型的对象，但是不能实例 java.io.File ，因为 String 类型是 Comparable[String] 的子类型，File不是。
  val p = new Pair3[String]("Scala", "Java")


  // 下界：
  // 例如，我们想定义一个方法，用另一个值替换对偶的第一个组件。我们的对偶是不可变的，因此我需要返回一个新的对偶。

  // 第一个尝试思路：
  class Pair4[T](first: T, second: T) {
    def replaceFirst(newFirst: T) = new Pair4[T](newFirst, second)
  }

  // 第二个尝试思路：


  class Person(id: Int, name: String) {}

  class Student(number: Int, id: Int, name: String) extends Person(id, name) {}

  val p1 = new Student(1,1,"Scala")
  val p2 = new Student(2,2,"Java")
  // 假定我们有一个如下 Pair4 对象
  val ps = new Pair4[Student](p1, p2)
}
