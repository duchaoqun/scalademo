package cn.duchaoqun.Chapter05

object Demo09 extends App {

  trait Printable extends Any {
    def print(): Unit = println(this)
  }

  class Wrapper(val underlying: Int) extends AnyVal with Printable

  val w = new Wrapper(3)
  w.print() //info.aoye.scala.Wrapper@3

  def error(message: String): Nothing = {
    throw new RuntimeException(message)
  }

  def divide1(x: Int, y: Int): Any = {
    if (y != 0) x / y else "ddd"  // 两个分支，一个返回 Int 类型，一个返回 String 类型，整体返回的表达式类型是 Any 。
  }

  def divide2(x: Int, y: Int):Int = {
    if (y != 0) x / y else error("Cannot divide by Zero")  // error 返回的类型是 Nothing，他是所有类型的子类，因此 if 表达式的类型就还是 Int。
  }

  divide1(10, 0)
  divide2(10, 0)
}


