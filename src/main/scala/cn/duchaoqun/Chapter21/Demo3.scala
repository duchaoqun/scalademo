package cn.duchaoqun.Chapter21

import scala.collection.mutable.ListBuffer

/**
  * 21.3 引入隐式转换
  *
  * Scala 会考虑如下两种场景上的隐式转换函数
  * 1. 位于源类型或者目标类型的伴生对象中的隐式转换函数。
  * 2. 位于当前作用域可以以单个标识符指代的隐式函数。
  */
object Demo21_3 extends App {

  val dogList = ListBuffer(Dog("Dog - Demo21_3"))
  val p1 = Person("Person - Demo21_3")

  // 场景1：在当前的作用域中可以找到能使用的隐式转换函数。
  implicit def person2Dog(person: Person): Dog = {
    Dog(person.name)
  }


  // 场景2：这里会自动调用源类型 Person 的伴生对象中的隐式转换函数，将 p1 转换成 dogList 能接收的 dog 对象。
  dogList.addOne(p1)

  // 场景3：我们把这个隐式转换单独放置在一个【单例对象】中，这里可以进行引入。
  // 注意：可以在局部代码块中进行引用，避免发生其他异常的转换问题。
  import cn.duchaoqun.Chapter21.Demo21_3_Conversions                       // 引入【单例对象】本身
  import cn.duchaoqun.Chapter21.Demo21_3_Conversions._                     // 引入隐式内容
  import cn.duchaoqun.Chapter21.Demo21_3_Conversions.person2Dog            // 直接引入固定的隐式转换函数
  import cn.duchaoqun.Chapter21.Demo21_3_Conversions.{type2Type2 => _, _}  // 引入排除type2Type2外其他的隐式转换函数。

  // 场景4：我们可以显示的调用隐式转换函数。
  dogList.addOne(person2Dog(p1))
}

// todo: 主构造函数中的变量默认是私有的，需要用 val 修饰才能在其伴生对象中访问。
class Person(val name: String, val typeStr: String = "Person"){
  override def toString: String = { this.getClass + " - " + name }
}
object Person {
  def apply(name: String, typeStr: String = "Person"): Person = new Person(name, typeStr)

  // 定义一个隐式转换函数，把 person 转换成 dog 对象
  implicit def person2Dog(person: Person): Dog = {
    Dog(person.name)
  }
}

class Dog(val name: String, val typeStr: String = "Dog"){
  override def toString: String = { this.getClass + " - " + name }
}
object Dog {
  def apply(name: String, typeStr: String = "Dog"): Dog = new Dog(name, typeStr)
}


object Demo21_3_Conversions{
  // 定义一个隐式转换函数，把 person 转换成 dog 对象
  implicit def person2Dog(person: Person): Dog = {
    Dog(person.name)
  }

  implicit def type2Type2(person: Person): Dog = {
    Dog(person.name)
  }
}