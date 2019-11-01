package cn.duchaoqun.Chapter20

import akka.actor.Actor
import cn.duchaoqun.Chapter20.Demo02.Msg

object Demo01 extends App {

  class Actor01 extends Actor {
    // 重写 receive 函数，用来接收消息
    override def receive: Receive = {
      case "Hi" =>
        Thread.sleep(5000)
        println("Hi Scala!")
      case "Hello" =>
        Thread.sleep(5000)
        println("Hello Scala!")
      case "Stop" => // 终止当前线程的方法
        Thread.sleep(5000)
        context.stop(self)
        context.system.terminate()
      case Msg(id, name) => // 最好的接受消息的方式，使用模式匹配来接受 case class 对象中的数据。
        println(id + ":" + name)
      case _ => // 处理无效消息，避免“消息队列”被占满。
        println("Nothing to do!")
    }
  }

}
