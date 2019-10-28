package cn.duchaoqun.Chapter01

object Demo02 extends App {
  // scala.Byte
  // abstract final classByte extends AnyVal

  // 字节，一个 8 位带符号整数（相当于 Java 的 byte）是 scala.AnyVal 的一个子类型。在底层运行时系统中，Byte 的实例不是由对象表示的。
  // 有一个来自 scala 的隐式转换。提供有用的非基元操作的Byte => scala.runtime.RichByte。

  val byte1: Byte = 127

  println(byte1.getClass)
}
