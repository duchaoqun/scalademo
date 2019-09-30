package cn.duchaoqun

import cn.duchaoqun.Demo.{Man, Person}

object Main extends App {
  // 里氏替换原则：
  val p1 = new Person
  val p2 = new Man


  // 任何可以出现父类 Person 的地方，同样可以出现其子类。
  def display1(person: Person): Unit = {
    person.display()
  }
  // 如果使用的是一个子类的话，那么它不能适用于其父类。
  def display2(man: Man): Unit = {
    man.display()
  }

  display1(p2)
  // display2(p1) 错误的

  val xmax, ymax = 100

  println(1.toString)

  println(1.to(10))
  println(1 to 10)
  //String类型被隐式转换成StringOps类型，取出来两个字符串中的共同部分。
  println("hello".intersect("world"))

  // 在Scala中使用方法来转换类型，而不是使用强制类型转换
  println(99.99.toInt) // 得到 99
  println(99.toChar) // 得到 c
  println(99.toDouble) // 得到 99.0


  // 算数操作符
  // 这里的操作符符号其实都是方法名称，
  val answer = 5 * 8 + 2
  println(answer)

  // 这里没有++ 和 -- 操作符，这里使用+= 和 -=来实现，但是不推荐是var可变变量。
  var x = 1
  x += 1
  println(x)

  // 测试合并

  // 调用方法的时候可以省略的小括号，如果一个无参数的方法并不修改对象，调用的时候就不用写括号。
  println("Hello".sorted)


  //todo singleton object
  //todo package object

  import scala.math._ // 引入包

  // 通常，类都有一个伴生对象 companion object , 他的方法就跟Java中的静态方法一样。

  // apply方法
  val str1 = "Hello"
  println(str1(1))
  println(str1.apply(1))

  // 构建信的对象实例的常用方法，如下两个方法是一样的结果，从而取代了使用new 来创建对象实例。
  BigInt(1234) * BigInt(3456)
  BigInt.apply(1234) * BigInt.apply(3456)


  def test(): Unit = {
    println("测试合并代码")
    println("Test merge")
  }

  // 包对象：在其他的地方使用包对象中的内容。
  val name = cn.duchaoqun.Chapter7.defaultName
}
