package cn.duchaoqun.Chapter20

import akka.actor.{ActorRef, ActorSystem, Props}
import cn.duchaoqun.Chapter20.Demo01.Actor01

object Demo02 extends App {

  // Actor 是一个异步处理消息的对象，你向某个 Actor 发送消息，该 Actor 处理消息，可能还会向其他 Actor 发送消息。
  // 消息可以是任何对象，例如一个 String 对象、一个 Int 类型对象、或者其他更复杂的对象。

  // 声明一个 ActorSystem ，所有用户定义的 Actor 的宿主环境。
  val system = ActorSystem("HelloActor") // 线程名字HelloSystem-akka.actor.default-dispatcher-3

  // 创建一个 Actor 实例，返回结果类型尾 ActorRef，这里用的是默认构造函数，这可以理解成一个线程。
  val helloActor1: ActorRef = system.actorOf(Props[Actor01], name = "helloActor1")

  // 给Actor发送消息。
  helloActor1 ! "Hi"
  helloActor1 ! "Hello"
  helloActor1 ! "Exit"
  helloActor1 ! "Stop"


  // 最好的做法是使用 case class 来作为消息对象进行发送。
  case class Msg(id: Int, name: String)
  val helloActor2 = system.actorOf(Props[Actor01], name = "helloActor2")

  // 发送一个对象。
  helloActor2 ! Msg(1,"Scala")

}
