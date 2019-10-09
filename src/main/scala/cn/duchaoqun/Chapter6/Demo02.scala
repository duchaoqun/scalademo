package cn.duchaoqun.Chapter6

object Demo02 extends App {
  // BigInt是一个类，使用BigInt的伴生对象的 apply 方法构建一个对象。
  import scala.math._
  println(BigInt(123) * BigInt(123))
}

class Account1{
  // 类的伴生对象可以被访问，但是不在作用域当中。必须通过Account1.newUniqueNumber() 而不是newUniqueNumber()来访问。
  val id: Int = Account1.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount:Double): Unit = {
    balance += amount
  }
}

object Account1{
  private var lastNumber = 0
  def newUniqueNumber():Int = {
    lastNumber += 1
    lastNumber
  }
}
