package cn.duchaoqun.Chapter5

/**
  * 5.9 Any 类
  *
  * Scala 类继承结构中最顶层的，所有运行环境中的 Scala 类都是直接或间接继承自 Any 这个类。
  */
object Demo9 extends App {
  val w = new Wrapper(3)
  w.print() //info.aoye.scala.Wrapper@3

  /**
    * scala中的Nothing类型,是所有类型的子类.
    * @param message 抛出错误信息.
    * @return
    */
  def error(message: String): Nothing = {
    throw new RuntimeException(message)
  }

  def divide1(x: Int, y: Int): Any = {
    if (y != 0) x / y else "ddd"  //两个分支,一个返回Int类型,一个返回String类型,整体返回的表达式类型是Any
  }

  def divide2(x: Int, y: Int):Int = {
    if (y != 0) x / y else error("Cannot divide by Zero")  //error返回的类型是Nothing,他是所有类型的子类,因此if表达式的类型就还是Int
  }

  divide1(10, 0)
  divide2(10, 0)
}

trait Printable extends Any {
  def print(): Unit = println(this)
}

class Wrapper(val underlying: Int) extends AnyVal with Printable
