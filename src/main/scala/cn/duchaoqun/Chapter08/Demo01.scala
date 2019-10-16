package cn.duchaoqun.Chapter08

object Demo01 extends App {
  class Person {
    // final 修饰的属性不能被重写
    final val sex = "Man"
    val name = "Scala"
    val age = 0
  }

  final class Person1 {
  }

  class newPerson extends Person {
    // 可以复写父类的信息
    override val age = 11
  }
}

