package info.aoye.Chapter2

import java.net.{MalformedURLException, URL}

import scala.math._
/**
  * 2.12 异常
  *
  * 和Java一样抛出的对象必须是java.lang.Throwable的子类，和Java不同的是，Scala没有“受检查”异常--就是我们不需要声明这个
  * 函数或者方法可能会抛出某种异常。 例如Java代码： void doSomething() throw IOException
  */
object Demo2_12 extends App {
  // Note: throw表达式有特殊的类型Nothing，如果一个分支的类型是Nothing，那么if/else表达式的类型就是另外一个分支的类型。
  val x = 0
  // 第一个分支类型是Double，第二个分支类型是Nothing，那么这个表达式的结果类型就是Double
  if (x >= 0) sqrt(x) else throw new IllegalArgumentException("x should not be negative!")

  // 捕获异常的语法采用的是try/catch
  // Note: 常用的异常应该排在具体的异常之后。
  def process(url: URL){}

  try{
    process(new URL("http://www.baidu.com"))
  } catch {
    case _: MalformedURLException => println("Bad URL: ")
  } finally {
    // 释放资源代码，这里的代码无论process是否抛出异常都会被执行。
  }
}
