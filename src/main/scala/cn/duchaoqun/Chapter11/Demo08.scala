package cn.duchaoqun.Chapter11

object Demo08 extends App {

  // 定义这个类的伴生类
  class Person(val id: Int, val name: String) {}
  object Person {
    def unapply(arg: Person): Option[(Int, String)] = {
      if (arg == null) None
      else Some((arg.id, arg.name))
    }
  }

  val p1 = new Person(1, "Scala")
  val p2 = new Person(2, "Java")

  val Person(id,name) = p1 // 这里调用的 Person.unapply 方法，提取出内容。
  println(id + name)


}
