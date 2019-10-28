package cn.duchaoqun.Chapter17

object Demo12 extends App {

  // 我们没有办法给对象添加类型参数，比如可变列表，元素类型为 T 的列表要么是空的，要么是一个头部类型为T、尾部类型为List[T]的节点：

  abstract class List[+T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]
  }

  class Node[T](val head: T, val tail: List[T]) extends List[T] {
    override def isEmpty = false
  }

  class Empty[T] extends List[T] {
    override def isEmpty: Boolean = true

    override def head: T = throw new UnsupportedOperationException

    override def tail: List[T] = throw new UnsupportedOperationException
  }

  // 这里我们使用 Node 和 Empty 是为了让讨论对 Java 程序员而言比较容易。
  // 如果你非常熟悉 Scala，只要在脑海里面替换成 :: 和 Nil 即可。

  // 将 Empty 定义成类看上去有些傻，因为它没有状态，但是你有无法简单地将它变成对象：
  // object Empty[T] extents List[T] // 错误

  // 你不能将参数化的类型添加到对象，在本例中，解决方法是继承 List[Nothing]
  // object Empty extends List[Nothing]

  // Nothing 类型是所有类型的子类型，因此当我们构造如下单元素列表时：
  // val lst = new Node(42,Empty)
  // 类型检查时成功的，根据斜边的规则，List[Nothing] 可以被转换成 List[Int]，因而 Node[Int] 的构造器能够被调用。
}
