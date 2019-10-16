package cn.duchaoqun.Chapter08

object Demo04 extends App {
  protected val name = "Scala"        // 可以被子类访问，不能从其他位置访问。
  protected[this] val var_1 = "var_1" // 将访问权限限定在当前对象中。
}
