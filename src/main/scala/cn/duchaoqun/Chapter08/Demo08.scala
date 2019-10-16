package cn.duchaoqun.Chapter08

object Demo08 extends App {

  abstract class Person {
    def id: Int // 没有方法体，这是一个抽象方法
    def name: String
  }

  class newPerson extends Person {
    override def id: Int = 123 // 你可以使用override关键字，还是写上比较顺眼！
    def name = "Scala"         // 你也可以不写override关键字。
  }

}

