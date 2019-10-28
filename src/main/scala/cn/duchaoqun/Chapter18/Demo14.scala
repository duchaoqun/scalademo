package cn.duchaoqun.Chapter18

object Demo14 extends App {

  // 泛型类型 List 依赖于类型 T 并产出一个特定的类型。
  // 例如 给定类型 Int ，你得到的类型是 List[Int]。
  // 因此像 List 这样的泛型类型有时被称作 类型构造器（type constructor）
  // 在 Scala 中，你可以定义出依赖于 依赖其他类型的类型 的类型。

  trait Iterable[E] {
    def iterator(): Iterator[E]
    def map[F](f: E => F): Iterable[F]
  }

  // 现在，考虑一个实现该特质的类：
  class Buffer[E] extends Iterable[E] {
    override def iterator(): Iterator[E] = _

    override def map[F](f: E => F): Iterable[F] = _
  }

}
