package cn.duchaoqun.DemoAkka

import akka.actor.{Actor, ActorSystem, Props}

case class Cat(name: String, age: Int)

case class Dog(name: String, age: Int)

class Akka02 extends Actor {
  override def receive: Receive = {
    case Dog(name, age) => println("DOG:" + name + age)
    case Cat(name, age) => println("CAT:" + name + age)
    case _ => println("Nothing")
  }
}

/**
  * Scala 的 Actor 模型与 Java 的多线程模型之间很大的一个区别就是 Scala Actor 一个 actor 可以给其他 actor 直接发送消息。
  * 使用"actor ! message" 的语法，要给一个actor发送消息。
  * 使用 case class 来作为消息来发送 actor 接收消息之后，可以使用 scala 强大的模式匹配功能来进行不同消息的处理。
  */
object Demo02 extends App {
  val system = ActorSystem("Demo2")
  val demo2Actor = system.actorOf(Props[Akka02], name = "Akka02")

  demo2Actor ! Dog("Chris", 22)
  demo2Actor ! Cat("Lucy", 99)
}
