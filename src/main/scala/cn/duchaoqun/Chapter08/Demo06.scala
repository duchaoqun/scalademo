package cn.duchaoqun.Chapter08

object Demo06 extends App {

  abstract class Person {
    def id: Int // 每个对象都有一个以某种方式计算出来的id
  }

  class newPerson(override val id: Int) extends Person {
    // def 关键字只能重写另外一个def
    // val 能重写另一个val 或者不带参数的 def
    // var 只能重写另外一个 abstract var
  }

}