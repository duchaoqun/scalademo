package cn.duchaoqun.DemoAkka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * 官方文档：https://doc.akka.io/docs/akka/2.5/actors.html
  *
  * 在 2.10 以后的版本,Actor被独立出来发布,需要添加如下引用才可以使用.
  * libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.8"
  *
  * 在 2.13.0 版本中，需要使用如下引用方式
  * https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
  * libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.0-M7"
  *
  * Actor 通过尽可能避免锁和共享状态, Actor 使得我们能够更容易地设计出正确, 没有死锁或争用状况的程序。
  * Actor 可以更方便的实现多线程编程, Actor trait 类似于 Java 中的 Thread 和 Runnable 是基础的多线程基类和接口。
  * 我们只要重写 Actor 的 act 方法, 即可实现自己的线程执行体, 与 Java 中重写 run 方法类似。
  * 使用 start() 方法启动 actor, 使用 ! 符号向 actor 发送消息, actor 内部使用 receive 和模式匹配接收消息。
  */
object Demo01 extends App {
  // 声明一个 ActorSystem, 所有用户定义的 Actor 的宿主环境。
  val system = ActorSystem("HelloSystem")  // 线程名字HelloSystem-akka.actor.default-dispatcher-3

  // 创建一个 Actor 实例, 返回结果类型尾 ActorRef, 这里用的是默认构造函数, 这可以理解成一个线程吗?  todo// 需要深入学习
  val helloActor: ActorRef = system.actorOf(Props[Akka01],name = "ActorOne")

  // 给Actor发送消息.
  helloActor ! "Hello"
  helloActor ! "asdf"
  helloActor ! "Exit"
  helloActor ! "asdf"
  // TODO 线程如何复用? 怎么做呢?
}

class Akka01 extends Actor{
  override def receive: Receive = {
    case "Hello" => println("Hi!"+ Thread.currentThread().getName); Thread.sleep(3000)
    case "Exit" =>  System.exit(0) //todo 如何安全终止这个线程?
    case _ => println("您是?") ; Thread.sleep(1000)
  }
}
