package cn.duchaoqun.Chapter18

import scala.collection.mutable.ArrayBuffer

object Demo14 extends App {

  // 泛型类型 List[T] 依赖于类型 T 并产出一个特定的类型。
  // 例如：给定类型 Int ，你得到的类型是 List[Int]。
  // 因此像 List[T] 这样的泛型类型有时被称作 类型构造器（type constructor）
  // 在 Scala 中，你可以定义出依赖于 依赖其他类型的类型 的类型。


  // 如下是一个简化过的 Iterable 特质，实际上在使用的时候该特质需要实现很多方法。
  trait Iterable[E] {
    def iterator(): Iterator[E]

    def map[F](f: E => F): Iterable[F]
  }

  // 现在，考虑一个实现该特质的类：
  // class Buffer[E] extends Iterable[E] {
  //   override def iterator(): Iterator[E] = _
  //   override def map[F](f: E => F): Iterable[F] = _
  // }
  // 对于 Buffer 类，我们预期它的 map 方法返回一个 Buffer 对象，而不仅仅是 Iterable。
  // 这意味着我们不能在 Iterable 特质中实现这个 map 方法。

  // 一个解决方案是使用类型构造器来参数化 Iterable：

  trait Iterable_1[E, C[_]] {
    def iterator(): Iterator[E]

    def build[F](): C[F]

    def map[F](f: E => F): C[F]
  }

  // 这样一来，Iterable 就依赖一个类型构造器来生成结果，以 C[_] 表示，这使得 Iterable_1 成为一个高等类型。

  // map 方法返回的类型可以是，也可以不是 与 调用该 map 方法的原 Iterable 相同的类型。
  // 例如：你对 Range 执行 map 方法，结果通常不会是另外一个 Range 对象，因此 map 必须构造出另一种类型，比如 Buffer[F]。
  // 这样的一个 Range 类型声明如下：
  // class Range extends Iterable_1[Int, Buffer] {}

  // 注意第二个参数是类型构造器 Buffer
  // 要实现 Iterable_1 中的 map 方法，我们需要寻求更多的支持。
  // Iterable 需要能够产出一个包含了任何类型 F 的值的容器。

  // 我们来定义一个 Container 类 -- 某种你可以向它添加值得东西：
  trait Container[E] {
    def +=(e: E): Unit
  }

  trait Iterable_2[E, C[X] <: Container[X]] {
    def iterator(): Iterator[E]

    // 类型构造器 C 现在被限定为一个 Container，因此我们知道可以向 build 方法返回的对象添加项目。
    // 我们不再对参数 C 使用通配符，因为我们需要表明 C[X] 是一个针对同样的 X 的容器。
    def build[F](): C[F]

    // 有了这些，我们就可以在 Iterable 中实现 map 方法了：
    def map[F](f: E => F): C[F] = {
      val res = build[F]()
      val iter = iterator()
      while (iter.hasNext) res += f(iter.next())
      res
    }

  }

  // 这样一来，可迭代（Iterable）类就不再需要提供它们自己的 map 实现了。
//  class Range(val low: Int, val high: Int) extends Iterable_2[Int, Buffer] {
//    def iterator() = new Iterator[Int] {
//      private var i = low
//
//      def hasNext = i <= high
//
//      def next() = {
//        i += 1;
//        i - 1
//      }
//    }
//  }

  // 注意 Range 是一个 Iterable：你可以遍历其内容，但它并不是一个 Container： 你不能对他添加值。

  // 而 Buffer 则不同，他既是 Iterable，也是 Container：

//  class Buffer[E: Manifest] extends Iterable_2[E, Buffer] with Container[E] {
//    private var capacity = 10
//    private var length = 0
//    private var elems = new Array[E](capacity)
//
//    def iterater() = new Iterator[E] {
//      private var i = 0
//
//      def hasNext = i < length
//
//      def next() = {
//        i += 1; elems(i - 1)
//      }
//    }
//
//    def build[F: Manifest](): Buffer[F] = new Buffer[F]
//
//    def +=(e: E): Unit = {
//      if (length == capacity){
//        capacity = 2 * capacity
//        val nelems = new Array[E](capacity)
//        for (i <- 0 until length) nelems(i) = elems(i)
//        elems = nelems
//      }
//      elems(length) = e
//      length += 1
//    }
//  }

  // 上述示例展示了高等类型的典型应用。 Iterator 依赖 Container，但Container不是一个普通的类型==他是制作类型的机制。
  // Scala 集合类库中的Iterable 特质并不带有显示的参数用于制作集合，而是使用隐式参数来带出一个对象用于构建目标集合。

}
