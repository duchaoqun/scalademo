package cn.duchaoqun.Chapter11

/**
  * 11_1 标识符
  * 变量、函数、类等名称被统称为标识符。
  */
object Demo11_1 extends App {

  // 1. 经典的方法：字母、数组字符组成，以字母的下划线开头。
  val input1 = ""
  val next_token = ""

  // 2. 你还可以使用Unicode字符，此外你还可以使用各种特殊符号，这些都是合法的（不方便输入，不方便阅读，不太爽）。

  // 3. 你甚至可以使用反引号，来使用关键字作为标识符（完全不推荐）。
  val `val` = ""
  // 在调用 Java 的方法的时候，有时候你需要使用反引号来进行操作。
  Thread.`yield`()
}
