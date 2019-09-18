package cn.duchaoqun.DemoCaseClass


case class Demo02_Person1(name: String, age: Int, sex: String) // 推荐做法，默认就是val类型。
case class Demo02_Person2(var name: String, var age: Int, var sex: String) // 不推荐
case class Demo02_Person3(val name: String, val age: Int, val sex: String) // 不推荐

object Demo02 extends App{
  // case class 是定义类的语法糖。
  // 在这些类中，所有构造函数参数都应该是公共的、不可变的，默认会自动帮我们实现一些方法，例如apply、unapply、getter、setter等。
  // 如果使用var关键字来声明，就破环了一些特性，如果你需要改变一些东西，不要使用case class。
}