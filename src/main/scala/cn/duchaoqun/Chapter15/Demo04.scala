package cn.duchaoqun.Chapter15


object Demo04 extends App {
  @unchecked
  val a:String = "Scala"
  // 创建注解必须继承 Annotation 特质。
  class unchecked extends scala.annotation.Annotation {}

  // todo 这里待学习。
}
