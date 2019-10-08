package cn.duchaoqun.Chapter15

/**
  * 4. 创建注解
  *
  * 大部分时候我们不需要创建自己的注解。
  */
object Demo4 extends App {
  @unchecked
  val a:String = "Scala"
  // 创建注解必须继承 Annotation 特质。
  class unchecked extends scala.annotation.Annotation {}

  // todo 这里待学习。
}
