package cn.duchaoqun.Chapter1

object Demo1_4 extends App {

  // ASCII 65 的值是字符 A
  val x: Int = 65
  // 将 Int 值转换成 Char 字符
  val y: Char = x.toChar

  // 中文字符的转换
  val char:Char = '我'
  println(char.toInt)
}
