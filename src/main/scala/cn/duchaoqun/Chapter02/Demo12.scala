package cn.duchaoqun.Chapter02

import java.io.{FileNotFoundException, FileReader}
import java.net.{MalformedURLException, URL}

import scala.math._


object Demo12 extends App {

  // 自定义一个 Exception 类型
  case class MyException(msg: String) extends Exception {
    override def getMessage: String = {
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
