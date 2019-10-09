package cn.duchaoqun.Chapter05

/**
  * 5.2 "getter" and "setter" 属性
  */
object Demo2 extends App {
  val person = new Person
  println(person.name) // 调用getter方法
  person.age = 21      // 调用setter方法
  println(person.age)  // 调用getter方法

}

class Person {
  // class 中的字段自动带有"getter" and "setter" 属性
  val name = "Scala"

  // var 类型的成员可以被赋值，在创建的对象后，这里的 age 可以被赋值。
  var age = 0

  // 私有的成员
  private var privateHeight = 0

  def height: Int = privateHeight

  // 你可以用定制的getter/setter方法替换掉字段的定义，而不必修改使用类的客户端（所谓的统一访问原则）
  //TODO：自定义getter和setter方法
  //  def height_ = (newValue: Int){
  //    if (newValue > privateHeight) privateHeight = newValue else privateHeight
  //  }
  // TODO：  用@beanProperty注解来生成JavaBeans的getXxx/setXxx方法。
}
