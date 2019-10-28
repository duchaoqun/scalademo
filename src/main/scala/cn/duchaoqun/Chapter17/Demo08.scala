package cn.duchaoqun.Chapter17

object Demo08 extends App {

  // 类型约束提供的是另一个限定类型的方式

  // T =:= U 测试 T 是否等于 U
  // T <:< U 测试 T 是否是 U 的子类型
  // T <%< U 测试 T 是否能被隐式转换为 U 类型

  // 如下来看，类型约束并没有类型界定更有用。
  class Pair1[T](val first: T, val second: T)(implicit ev: T <:< Comparable[T])

  class Pair2[T <: Comparable[T]]


  // 用途：类型约束让你可以在泛型类中定义只能在特定条件下使用的方法。
  class Pair3[T](val first: T, val second: T) {
    def smaller(implicit ev: T <:< Ordered[T]): T = if (first < second) first else second
  }

  // 这样你可以构造出Pair[File]，尽管File并不是带先后顺序的。只有当你调用 smaller 方法的时候才会报错。

  // Option 类型的 orNull 方法。
  val friends = Map("Fred" -> "Barney")
  val friendsOpt = friends.get("Wilma") // Option[String]
  val friendOrNull = friendsOpt.orNull // 要么是String，要么是null
  // 在和 Java 打交道的时候 orNull 方法就很有用了，因为Java中通常习惯于用 null 表示默认缺少某个值。
  // 不过这种做法并不适用于值类型，比如 Int，它们并不把 null 看作是合法的值。
  // 因为 orNull 的实现带有约束 Null<:<A，你仍然可以实例化 Option[Int]，只要你别对这些实例使用 orNull 就好了。


  // 用途：改进类型推断
  def firstLast[A, C <: Iterable[A]](it: C) = (it.head, it.last)

  // 当你执行代码 firstLast(List(1,2,3) 的时候
  // 你会得到一个消息，推断出的类型参数 [Nothing. List[Int]] 不符合 [A, C <: Iterable[A]]
  // 为什么是 Nothing 类型？ 类型推断器单凭 List(1,2,3) 无法判断出上界 A 是什么，因为它是在同一个步骤中匹配到 A 和 C 的。
  // 要帮助它解决这个问题，首先匹配出 C ，然后再匹配 A

  def firstLastNew[A, C](it: C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last)
}
