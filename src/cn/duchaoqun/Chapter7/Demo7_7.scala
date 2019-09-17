package cn.duchaoqun.Chapter7

/**
  * 7.7 包引入
  * 包引入让你可以使用更短的名称，而不是原来较长的名称。
  */
object Demo7_7 extends App {
  // 引入之后你就可以使用较短的名称Timer，而不是java.util.Timer
  import java.util.Timer

  // 可以引入包中的所有内容 _ 和java的*
  import java.util._

}
