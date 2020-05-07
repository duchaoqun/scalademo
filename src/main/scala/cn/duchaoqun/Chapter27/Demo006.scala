package cn.duchaoqun.Chapter27

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


import scala.util.{Failure, Success}


/**
  * 1. 当程序中的某个过程执行时间较长, 同时它与程序中的其他环节没有很强的关联性, 那么这个过程便可以提取出来作为一个线程单独运行.
  * 2. Scala 中的 Future 便是用来解决此类问题, 可以将用于并发执行的操作添加到 Future 中, 然后在未来的某个时间点再获取其执行结果.
  * 3. Future 的状态主要有两类, 完成与未完成, 而完成状态又分为成功与失败, 成功会有并发执行函数的返回值, 失败则会抛出异常.
  */
object Demo006 extends App {
  //案例1:创建Future类型的函数
  //创建Future对象,对象中保存单个Future
  val division0: Future[Int] = Future {
    10 / 2
  }
  // class scala.concurrent.impl.Promise$Transformation
  println(division0.getClass)

  // callback
  // Future 对象 onComplete 方法接收一个 偏函数对象 作为参数。
  // def onComplete[U](f: Try[T] => U) ：偏函数的类型是 PartialFunction[Try[T], U]，然后分别处理成功和失败的两种结果。
  division0 onComplete { //第一个回调函数,接收Future的返回结果
    case Success(x) => println("Callback1:" + x) //处理成功
    case Failure(e) => println("Callback1:" + e.getMessage)
  }


  // 案例2: 创建一个方法来包含执行过程.
  def division(x: Int, y: Int): Int = {
    Thread.sleep(1000)
    x / y
  }

  // 调用 Future.sequence 创建并发执行函数.
  val division1: Future[Seq[Int]] = Future sequence Seq(
    Future(division(10, 2)),
    Future(division(10, 3))
  )

  division1 onComplete {
    case Success(List(x, y)) => println(s"$x + $y") //使用List[T]或者Seq[T] 接收Future的返回结果.
    case Failure(exception) => println("Error:" + exception.getMessage) //接收异常
  }

  // todo 自定义ExecutionContext
  // 从上面回调函数的API看出,它们传入了一个隐式参数implicit executor: ExecutionContext 一般只需要引入对应的类就行了,不需要再手动传入.
  // import scala.concurrent.ExecutionContext.Implicits.global
  // 但是在使用过程中发现,默认的ExecutionContext所能开辟的Future线程是受到机器CPU核数影响,
  // 那么超过核数的线程将会排队等待前面的线程完成才能开始,所以需要调大线程数.
  // ExecutionContext类中提供了一个自定义的方法

  // todo https://blog.csdn.net/ratsniper/article/details/47177619

  // todo 通过Future对象的foreach方法执行内容.
  division0.foreach(msg => println(msg))
  Thread.sleep(10000) //为了看到效果,主线程等待10秒.

  // todo andThen function
}
