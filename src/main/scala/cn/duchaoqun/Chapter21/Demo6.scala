package cn.duchaoqun.Chapter21

/**
  * 21.6 利用隐式参数进行隐式转换
  *
  * 隐式的参数列表也可以被用作隐式转换。
  */
object Demo6 extends App {

  // 举例：想找到两个目标中较小的那个，定义如下泛型函数，这是不行的，因为编译器不知道 a 和 b 是一个带有 【<】操作符的类型。
  //def smaller[T](a: T, b: T) = if (a < b) a else b

  // 我们可以提供一个转换函数来达到这个目的，因为 Ordered[T] 特质有一个接受 T 作为参数的 < 操作符。
  // 也许是巧合，这种情况非常常见，Predef 对象对大量已知类型都定义了 T => Ordered[T]，包括所有已经实现了 Order[T] 或 Comparable[T] 的类型。
  def smaller[T](a: T, b: T)(implicit ordered: T => Ordered[T]): T = {
    // (implicit ordered: T => Ordered[T]) 不仅是一个隐式参数，还是一个隐式转换，所以在函数体里面可以去掉 ordered 隐式函数的显示调用。
    if (ordered(a) < b) a else b
    // if (a < b) a else b
  }


  smaller(2, 4)
  smaller("Java", "Scala")
}
