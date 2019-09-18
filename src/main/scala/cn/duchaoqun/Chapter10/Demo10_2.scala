package cn.duchaoqun.Chapter10

/**
  * 10.2 当作接口使用的特质
  *
  * Scala 中的 trait 完全可以按照接口的方式来使用
  * Java中的所有接口都可以作为特质来使用。
  * 和Java一样，Scala可以继承一个父类，继承很多个特质。
  */
object Demo10_2 extends App {

}

trait Logger{
  // 定义一个抽象的方法，这里不需要使用 abstract 关键字来修饰，在特质里面，没有方法体的默认就是抽象方法。
  def log(msg:String)
}

// 在需要多个特质的时候，后面的可以使用With关键字。
// 注意，理解方式是： Logger with Cloneable with Serializable 先是一个整体，然后再被Logger继承。
class ConsoleLogger extends Logger with Cloneable with Serializable {
  // 子类实现特质的抽象方法，可以不写override，但我感觉还是写上好看些。
  override def log(msg: String): Unit = {
    println("msg")
  }
}