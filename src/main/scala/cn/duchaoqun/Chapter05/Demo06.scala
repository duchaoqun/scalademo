package cn.duchaoqun.Chapter05

object Demo06 extends App {

  class Person1(name: String, age: Int) {
  }

  class Person2(name: String, age: Int) {
    // 主构造器会执行类体中的所有语句。
    // 每当有对象被创建出来的时候，下述println代码就会被执行，【当你在构造过程中配置某个字段时，这个特性非常有用】
    println("Just constructed another person!")

    def description: String = name + "is" + age + "years old."
  }

  // 如果类名没有参数，则这个类具有一个无参的主构造器，这样的构造器仅仅是简单地执行类体中的所有语句而已。
  class Person3 {
    println("Person02!")
  }

  // 你通常可以在主构造器中使用默认参数，来避免使用过多的辅助构造器。
  class Person4(name: String = "", age: Int = 0) {
    println("Person02!")
  }

  val p01 = new Person1("Scala", 1)
  val p02 = new Person2("Java", 2)
  val p03 = new Person3

  /*
  不同形态的主构造器参数说明：

  1. (name: String)
     生成的字段/方法：对象的私有字段，如果没有方法使用 name，则没有该字段。

  2. (private val/var name: String)
     生成的字段/方法：私有字段，私有的 getter/setter 方法。

  3. (val/var name: String)
     生成的字段/方法：私有字段，公有的 getter/setter 方法。

  4. (@BeanProperty name: String)
     生成的字段/方法：私有字段，公有的 Scala 版 getter/setter 方法，公有的 Java 版 getName/setName 方法。

   */
}


