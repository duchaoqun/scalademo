package cn.duchaoqun.Chapter08

object Demo07 extends App {

  class Person(id:Int){}

  // 你可以通过包含带有定义或者重写的代码块的方式创建一个匿名的子类
  // 这将会创建出一个结构类型对象，该类型标记为 Person{def vars:String}
  val alien: Person = new Person(123) {
    def vars = "Scala"
  }

  def meet(p: Person{def vars:String}): Unit ={
    println(p.vars)
  }
}


