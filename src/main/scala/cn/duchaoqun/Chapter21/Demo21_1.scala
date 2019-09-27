package cn.duchaoqun.Chapter21

import scala.collection.mutable.ListBuffer

/**
  * 21.1 隐式转换
  */
object Demo21_1 extends App {

  // implicit conversion function 是指用 implicit 关键字声明，带有单个参数的函数，这样的函数会被自动应用，将值从一种类型转换成另外一种类型。

  // 定义两种类型用作测试
  case class Person(name:String,typeStr: String = "Person")
  case class Dog(name:String, typeStr:String = "Dog")

  // 定义一个隐式转换函数，把 person 转换成 dog 对象
  implicit def person2Dog (person: Person): Dog = {
    Dog(person.name)
  }


  val dogList = ListBuffer(Dog("LaLa"))
  val p1 = Person("John")

  // 这里会自动调用上面的隐式转换函数，将 p1 转换成 dogList 能接收的 dog 对象。
  dogList.addOne(p1)

}
