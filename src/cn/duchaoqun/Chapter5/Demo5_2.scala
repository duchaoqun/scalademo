package cn.duchaoqun.Chapter5

/**
  * 5.2 带getter和setter的属性
  */
object Demo5_2 extends App {
  val person = new Person
  person.age = 21 // 调用setter方法
  println(person.age) // 调用getter方法
}

class Person {
  var age = 0
  private var privateHeight = 0

  def height: Int = privateHeight

  //TODO：自定义getter和setter方法
//  def height_ = (newValue: Int){
//    if (newValue > privateHeight) privateHeight = newValue else privateHeight
//  }
}
