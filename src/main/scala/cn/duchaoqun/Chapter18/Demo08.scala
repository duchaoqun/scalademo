package cn.duchaoqun.Chapter18

import javax.swing.JComponent

object Demo08 extends App {
  // 存在类型被加入到 Scala 中是为了与 Java 的类型通配符兼容，存在类型的定义方式是在类型表达式之后跟上 forSome{...}
  // 花括号中包含了 type 和 val 的声明。

  // Array[T] forSome {type T <: JComponent}

  // 与“类型通配符”的效果是一样的

  // Array[_ <: JComponent]

  // Scala 的类型通配符是“存在类型”的“语法糖”

  // Array[_] 等于 Array[T] forSome {type T}
  // Map[_, _] 等于 Map[T, U]  forSome {type T, type U}

  // forSome 表示法允许我们使用更复杂的关系，而不仅限于类型通配符能表达的那些：
  // Map[T, U]  forSome {type T, type U <: T}
}
