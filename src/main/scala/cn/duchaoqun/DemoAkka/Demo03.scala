package cn.duchaoqun.DemoAkka

import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging

class Akka03 extends Actor {
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case "test" => log.info("received test")
    case _      => log.info("received unknown message")
  }
}

object Demo03 extends App {

}
