package cn.duchaoqun.Chapter01

/**
  * 1.7 Scala 基本数据类型 Char
  */
object Demo7 extends App {
  // Char 字符类型，字符是半角单引号括住的字符。
  val valueChar: Char = 'a'      // 16 bit Unicode字符.范围在 U+0000 <-> U+FFFF 之间.
  val x: Int = 65                // ASCII 65 的值是字符 A
  val y: Char = x.toChar         // 将 Int 值转换成 Char 字符
  val char:Char = '我'           // 中文字符的转换
  println(char.toInt)
}
