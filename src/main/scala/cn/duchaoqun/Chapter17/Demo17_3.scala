package cn.duchaoqun.Chapter17

/**
  * 17.3 类型参数的上下界定
  */
object Demo17_3 extends App {

  // 有时，你需要对类型变量进行限制，例如下面的Pair类型，它要求它的两个组件类型相同
  class Pair1[T](first: T, second: T) {}

  // 现在你想添加一个方法，返回比较小的那个内容：如下的写法会产生错误。
  class Pair2[T](first: T, second: T) {
    //def smaller = if(first.compareTo(second) < 0) first else second // 这个方法是错误的，我们不知道 first 有 compareTO方法。
  }


  // 上界：
  // 简单理解：类的继承关系，从Any开始，会发展出一个庞大的“根系”，上界就是以当前“类型参数”为界限，限定为界限以下的部分，这个类型就是最上的界限。
  // 所以输入的参数必须是这个【界限】类型，或者是继承这个【界限】的子类型。

  // 要解决上面的问题，我们可以添加一个上界：
  class Pair3[T <: Comparable[T]](first: T, second: T) {
    def smaller: T = if (first.compareTo(second) < 0) first else second
  }

  // T <: Comparable[T] 说明 T 必须是 Comparable[T] 的子类型

  // 这样我们就可以实例化 String 类型的对象，但是不能实例 java.io.File ，因为 String 类型是 Comparable[String] 的子类型，File不是。
  val p = new Pair3[String]("Scala", "Java")



  // 下界：
  // 简单理解：类的继承关系，从Any开始，会发展出一个庞大的“根系”，下界就是以当前“类型参数”为界限，限定为界限以上的部分，这个类型就是最下的界限。
  // 所以输入的参数必须是这个【界限】类型，或者是这个【界限】类型的父类。


  // 如下举例说明：我们想定义一个方法，用另一个内容替换 Pair4 的第一个内容。我们的对偶是不可变的，因此我需要返回一个新的对偶。

  // 定义基本类型
  class Person(id: Int, name: String) {}
  class Student(number: Int, id: Int, name: String) extends Person(id, name) {}

  class Pair4[T](first: T, second: T) {

    // 第一个思路：新的内容必须与原来的内容类型相同，返回新的 Pair4 对象（结果类型不变）。
    def replaceFirst1(newFirst: T) = new Pair4[T](newFirst, second)

    // 第二个思路：使用下界，传入的参数的类型需要时 T 或者是 T 的父类型 R 返回的结果类型是 Pair4[R]
    def replaceFirst2[R >: T](newFirst: R) = new Pair4[R](newFirst, second)
    // 第二个思路：使用下界，后面返回的 new Pair4 可以不用写“类型参数” Scala 会自动推断出具体的返回值类型
    def replaceFirst3[R >: T](newFirst: R) = new Pair4(newFirst, second)

    // 如果不写“下界”，返回的类型是 Pair4[Any]，这样写好像没什么意义哈..
    def replaceFirst4[R](newFirst: R) = new Pair4(newFirst, second)
  }

  val p1 = new Student(1, 1, "Scala")
  val p2 = new Student(2, 2, "Java")
  val p3 = new Person(1,"Scala")
  // 假定我们有一个如下 Pair4 对象
  val ps = new Pair4[Student](p1, p2)
  val res = ps.replaceFirst3(p3,p1)
  println(res.getClass)

  // 我们应该允许使用Person 对象来替换掉 Pair4 中的第一个内容。当然，这样做的结果应该得到一个 Pair4[Person] 对象。
  // 通常而言，替换进来的类型必须是原来类型的父类型。


}
