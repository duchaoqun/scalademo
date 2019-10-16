package cn.duchaoqun.Chapter08

object Demo02 extends App {

  class Person {
    // final 修饰的属性不能被重写
    final val sex = "Man"
    val name = "Scala"
    val age = 0
  }

  class newPerson extends Person{
    override val name: String = "Java"
    // 调用父类的方法和 Java 一样，使用 super 关键字。
    override def toString: String = super.toString + "Scala"
  }
}
