package cn.duchaoqun.Chapter02

import java.io.{FileNotFoundException, FileReader}
import java.net.{MalformedURLException, URL}

import scala.math._


/**
  * 1. 与 Java 一样抛出的对象必须是java.lang.Throwable的子类，和Java不同的是，Scala没有“受检查”异常（就是我们不需要声明这个）。
  * 2. 在 Scala 中 method 可以通过抛出异常的方法的方式来终止相关代码的运行，不必通过返回值。
  * 3. 在 Scala 中借用了模式匹配的思想来做异常的匹配，因此，在 catch 的代码里，是一系列 case 子句。
  * 4. catch 子句是按次序捕捉的，因此，在 catch 子句中，越具体的异常越要靠前，越普遍的异常越靠后。如果抛出的异常不在 catch 子句中，该异常则无法处理，会被升级到调用者处。
  * 5. finally 语句用于执行不管是正常处理还是有异常发生时都需要执行的步骤。
  */
object Demo2_12 extends App {

  // 自定义一个 Exception 类型
  case class MyException(msg:String) extends Exception{
    override def getMessage:String = {
      msg
    }
  }

  // 使用自定义的 Exception 类型
  val x = 0
  if (x >= 0) {
    sqrt(x)
  } else {
    throw MyException("Test Exception!")
  }


  // 捕获异常的语法采用的是try/catch
  // 常用的异常应该排在具体的异常之后。
  def process(url: URL) {}

  try {
    process(new URL("http://www.baidu.com"))
  } catch {
    case _: MalformedURLException => println("Bad URL: ")
  } finally {
    // 释放资源代码，这里的代码无论process是否抛出异常都会被执行。
  }

  try {
    val f = new FileReader("Test.txt")
  } catch {
    case ex: FileNotFoundException => println(ex.getMessage) // Test.txt (系统找不到指定的文件。)
    case ex: FileNotFoundException => println(ex) // java.io.FileNotFoundException: Test.txt (系统找不到指定的文件。)
    case ex: FileNotFoundException => println("IOException") // 打印自己的信息，感觉还是使用默认的比较好。
  } finally {
    println("其他的代码：无论有没有发生异常，这里的代码都会运行。")
  }
}
