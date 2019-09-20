package cn.duchaoqun.DemoSpider

import akka.actor.Actor

class GetPage extends Actor{
  override def receive: Receive = {
    case "out" => println("")
  }
}
