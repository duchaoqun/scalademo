package cn.duchaoqun.DemoAkka

import akka.actor.{ActorSystem, Props}
import cn.duchaoqun.Chapter20.Actor01

object Demo06 extends App {

  private val actorSystem = ActorSystem("actorSystem")

  private val helloActorRef = actorSystem.actorOf(Props[Actor01], "Actor01010")

  val msg1 = "A"

  val msg2 = "B"

  val msg3 = "stop"

  helloActorRef ! msg1

  Thread.sleep(10000)

  helloActorRef ! msg2

  Thread.sleep(10000)

  helloActorRef ! msg3

  Thread.sleep(10000)

}
