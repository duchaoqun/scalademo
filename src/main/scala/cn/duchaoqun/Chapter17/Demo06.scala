package cn.duchaoqun.Chapter17

object Demo06 extends App {

  // 要实例化一个泛型的 Array[T] ,我们需要一个 Manifest[T] 对象。

  // 要想让基本类型的数组能正常工作的话，这是必须的。

  // 举例来说：如果 T 是 Int，你希望虚拟机中对应的是一个 int[] 类型的数组。
  // 在 Scala 中，Array 只不过是类库提供的一个类，编译器并不对它做特殊处理。
  // 如果你要编写一个泛型函数来构造泛型数组的话，你需要传入这个 Manifest 对象来帮忙。

  // 由于它是构造器的隐式参数，你可以使用上下文界定：

  def makePair[T: Manifest](first: T, second: T) = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }

  // 如果你调用 makePair(4, 9) ，编译器将定位到隐式的 Manifest[Int] 并实际上调用 makePair(4,9)(intManifest)
  // 这样一来，该方法调用的就是 new Array(2)(intManifest)，返回基本类型的数组 int[2]


}
