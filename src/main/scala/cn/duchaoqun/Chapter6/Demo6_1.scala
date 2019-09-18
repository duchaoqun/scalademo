package cn.duchaoqun.Chapter6

/**
  * 6.1 单例对象
  * Scala中没有静态方法或者静态字段，你可以使用单例对象来实现。
  * 作为存放工具函数和常量的地方。
  * 高效的共享单个不可变实例。
  */
object Demo6_1 extends App {
  Accounts.newUniqueNumber() // 对象的构造器在对象第一次使用的时候被创建
}

object Accounts{
  private var lastNumber = 0
  def newUniqueNumber():Int = {
    lastNumber += 1
    lastNumber
  }
}
