package info.aoye.Chapter8

/**
  * 8.11 继承层级
  * Any 是整个继承层级的根节点，提供isInstanceOf、asInstanceOf方法。
  * AnyVal 值类型标记
  * AnyRef 引用类型
  *
  * Null类型的唯一实例是null值，你可以将Null值赋值给任何引用。
  * Nothing类型没有实例，它对于泛型结构有用。
  * 例如 Nil 空列表的类型是 List[Nothing]，它是List[T]的子类型，T可以是任何类。
  */
object Demo8_11 extends App {
  val str1 = "Scala"
}
