package cn.duchaoqun.Chapter08

object Demo09 extends App {

  abstract class Person {
    val id: Int      // 抽象字段，就是没有初始化值的字段，带有getter方法
    var name: String // 抽象字段，带有 getter 和 setter方法
  }

  class NewPerson(val id: Int) extends Person {
    override var name: String = "Java"
  }

  // 可以随时使用匿名类型来定制抽象类
  val tmp1 = new Person {
    override val id: Int = 123
    override var name: String = "Java"
  }
}

