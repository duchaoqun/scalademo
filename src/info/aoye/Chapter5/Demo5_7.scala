package info.aoye.Chapter5

/**
  *  5.7 主构造器
  *  2. 主构造器的参数被编译成属性，被初始化为传入的参数值。
  */
object Demo5_7 extends App {
  val p01 = new Person02("Scala", 1)
  val p02 = new Person03("Java", 2)
  val p03 = new Person04
}

/**
  * 主构造器直接放置在类名之后，在Scala中每一个类都有一个主构造器，不使用this，它与类定义组合在一起。
  *
  * @param name 名字
  * @param age  年龄
  */
class Person02(name: String, age: Int) {
}

/**
  * 主构造器会执行类定义中的所有语句
  * 每当有对象被创建出来的时候，下述println代码就会被执行，【当你在构造过程中配置某个字段时，这个特性非常有用】
  *
  * @param name 名字
  * @param age  年龄
  */
class Person03(name: String, age: Int) {
  println("Just constructed another person!")

  def description: String = name + "is" + age + "years old."
}

/**
  * 如果类名没有参数，则这个类具有一个无参的主构造器，这样的构造器仅仅是简单地执行类体中的所有语句而已。
  */
class Person04 {
  println("Person04!")
}
