package cn.duchaoqun.Chapter17

object Demo13 extends App {

  // 在 Java 中，所有泛型类都是不变的，不过你可以在使用它们的时候使用通配符改变它们的类型。

  // void makeFriends(Pair <? extends Person > people) // 这是 Java 可以使用 List<Student> 作为参数调用。

  // 你也可以在 Scala 中使用通配符
  // def process(people: java.util.List[_ <: Person]  // 这是 Scala
  // 在 Scala 中，对于协变的 Pair 类，你不需要用通配符。但假定 Pair 是不变的：
  // class Pair[T](var first: T, var second:T)
  // 那么你可以定义
  // def makeFriends(p: Pair[_ <: Person]) // 可以用 Pair[Student] 调用
  // 你也可以对逆变使用通配符：

  // import java.util.Comparator
  // def min[T](p: Pair[T])(comp: Comparator[_ >: T])

  // 类型通配符是用来指代存在类型的“语法糖”

}
