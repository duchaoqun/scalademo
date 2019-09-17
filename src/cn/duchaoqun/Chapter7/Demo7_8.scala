package cn.duchaoqun.Chapter7

/**
  * 7.8 任何地方都可以引入包
  * 在Scala中任何地方都可以引入包，语句的效果一直延申到文件的结尾
  * 在适当的位置进行引入可以避免冲突
  */
object Demo7_8 extends App {
  import scala.collection.mutable.HashMap
}
