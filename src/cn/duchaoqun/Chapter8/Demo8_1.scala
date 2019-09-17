package cn.duchaoqun.Chapter8

/**
  * 8.1 扩展类
  *
  * 使用extends 关键字继承父类。
  */
object Demo8_1 extends App {

}

class Person {
  final val sex = "Man" // final 修饰的属性不能被重写
  val name = "Scala"
  val age = 0
}

/**
  * final 修饰的类不能被重写
  */
final class Person1 {
}

class Demo8_1_1 extends Person {

  // 可以复写父类的信息
  override val age = 11
}
