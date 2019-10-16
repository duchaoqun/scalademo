package cn.duchaoqun.Chapter08

object Demo05 extends App {

  class Person(name: String, age: Int) {}

  // 这段代码定义了一个子类Employee，他的主构造器有三个参数。
  // 其中有两个参数name和age被传递到父类的主构造器中。
  class Employee(name: String, age: Int, val salary: Double) extends Person(name, age) {
  }

  // Scala 继承 Java 类的时候，它的主构造器必须调用 Java 父类的某一个构造方法。
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width)

}