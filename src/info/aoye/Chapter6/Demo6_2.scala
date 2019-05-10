package info.aoye.Chapter6

/**
  * 6.2 伴生对象
  * 在Java中你通常会用到既有实例又有静态方法的类。
  * 类和伴生对象可以相互访问私有特性，它们必须在一个源文件中。
  */
object Demo6_2 extends App {

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
