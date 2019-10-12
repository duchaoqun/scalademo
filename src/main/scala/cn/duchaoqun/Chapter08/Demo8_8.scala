package cn.duchaoqun.Chapter08

/**
  * 8.8 抽象类
  *
  * 和Java一样，使用abstract关键字来定义抽象类，标记这个类不能被实例化，通常是因为它的某个或者几个方法没有定义完整。
  */
object Demo8_8 extends App {

}

abstract class Demo8_8_1{
  def id:Int // 没有方法体，这是一个抽象方法
  def name:String
}

class Demo8_8_2 extends Demo8_8_1{
  override def id: Int = 123  // 你可以使用override关键字，还是写上比较顺眼！
  def name = "Scala"          // 你也可以不写override关键字。
}