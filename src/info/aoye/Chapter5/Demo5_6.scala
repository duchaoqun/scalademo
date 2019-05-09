package info.aoye.Chapter5

/**
  * 5.6 辅助构造器
  * 1. 辅助构造器的名称为this，在修改类名时无需更改构造器名字
  * 2. 每一个辅助构造器必须一个对先前已经定义的其他辅助构造器或者主构造器的调用开始。
  */
object Demo5_6 extends App {
  val p0 = new Person01 // 调用默认的主构造器
  val p1 = new Person01("Scala")  // 第一个辅助构造器
  val p2 = new Person01("Java",2)  // 第二个辅助构造器
}

class Person01 {
  private var name = ""
  private var age = 0

  /**
    * 第一个辅助构造器
    *
    * @param name 名字
    */
  def this(name: String) {
    this() // 调用主构造器
    this.name = name
  }

  /**
    * 第二个辅助构造器
    *
    * @param name 名字
    * @param age  年龄
    */
  def this(name: String, age: Int) {
    this(name) // 调用前一个辅助构造器
    this.age = age
  }
}