package cn.duchaoqun.Chapter23

import scala.util.{Failure, Success, Try}

/**
  * Try 处理异常，与 Either 功能互补，都有各自的特点。
  */
object Demo005 extends App {

  // Demo: 定义 Try 对象，它会执行里面的内容，然后返回两种类型。
  val res1 = Try(10 / 0) // class scala.util.Failure
  val res2 = Try(10 / 2) // class scala.util.Success

  println("res1对象的类型是:" + res1.getClass) // class scala.util.Failure
  println("res2对象的类型是:" + res2.getClass) // class scala.util.Success

  // Try 对象 get 方法获取执行的结果，如果是 Failure 对象，会抛出异常并终止程序。
  println(res2.get)
  // Try 对象 getOrElse 方法，如果是Success类型，返回内容，否则返回指定内容。
  println(res2.getOrElse("Failure!"))

  // 使用 match case 表达式，匹配两种不同的结果对象，直接取到对象的执行结果。
  res1 match {
    case Success(v) => println("直接打印Success对象包含的值:" + v)
    case Failure(e) => println("直接打印Failure对象中错误值:" + e.getMessage)
  }


  // Demo：常用方法，执行一个可能出错的方法，然后使用 match case 表达式来接受返回结果。
  // 缺点：结果可能是 method1 的正确计算结果，也可能是一个错误对象。
  def method1: String = {
    "这里是method1!!"
  }
  val res3 = Try(method1) match {
    case Success(v) => v
    case Failure(e) => println(e.getMessage)
  }


  // Demo：更有效的方法，直接返回Try[T]类型,直接使用
  def method2: Try[String] = {
    Try("这里是method2!")
  }
  def method3(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }
  println(method3(10, 0).getOrElse("Failure!"))

  method3(10, 2) match {
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)
  }

  // 举例4: 当某一部分需要跳过错误的时候, 这里可以直接进行操作(但是个别时候错误的内容也需要保留)
  for (x<- 0 to 10){
    println(Try(10 / x))
  }


  // The code blow show you a sample try.
  try{
    // Some code.
  }catch {
    case e:Exception => e.printStackTrace()
  }
}
