package info.aoye.Chapter10

/**
  * 10.3 带有具体实现的特质
  */
object Demo10_3 extends App {

}

trait Demo10_3_1 {
  // 特质中的方法不一定是抽象的，这里定义一个方法体。
  def log(msg:String) {println(msg)}
}

/**
  * 这里Saving类从特质得到了一个log方法，在Java中是不能实现的。
  * 这里我们说：ConsoleLogger的功能被混入了Saving类（Saving类混入了ConsoleLogger的功能）。
  * 弊端：当特质改变时，所有混入了该特质的类都需要重新编译。
  */
class Saving extends Demo10_3_1{
  def withdraw(): Unit ={
    log("Scala")
  }
}
