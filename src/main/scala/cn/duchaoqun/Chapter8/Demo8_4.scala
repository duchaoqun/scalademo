package cn.duchaoqun.Chapter8

/**
  * 8.4 受保护的字段和方法
  */
object Demo8_4 extends App {
  // 和Java C++一样，可以将字段或者方法声明为protected，这样的成员可以被任何子类访问，但不能从其他位置访问到。

  protected val name = "Scala"
  protected[this] val var_1 = "var_1" // 将访问权限限定在当前对象中。
}
