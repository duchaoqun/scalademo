package cn.duchaoqun.Chapter05

object Demo07 extends App {

  class Person {
    private var name = ""
    private var age = 0

    // 第一个辅助构造器
    def this(name: String) {
      this() // 调用主构造器
      this.name = name
    }

    // 第二个辅助构造器
    def this(name: String, age: Int) {
      this(name) // 调用前一个辅助构造器
      this.age = age
    }
  }

  val p0 = new Person                           // 调用默认的主构造器
  val p1 = new Person("Scala")          // 第一个辅助构造器
  val p2 = new Person("Java", 2) // 第二个辅助构造器
}

