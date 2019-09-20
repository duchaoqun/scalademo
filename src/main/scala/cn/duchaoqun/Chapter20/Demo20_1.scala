package cn.duchaoqun.Chapter20

import akka.actor.Actor
import cn.duchaoqun.Chapter20.Demo20_2.Msg


/**
  * Actor 是扩展 Actor trait 的类
  * 这个类的对象就是一个线程，receive 方法不断地循环等待发送过来的消息，然后进行处理。
  * 发送到这个 Actor 的消息被存储到一个 “邮箱” 里面，receive 函数从邮箱中取出消息传递给自己的参数。
  * receive 方法的参数是一个偏函数，就是下面的 case 代码块，这个代码块被转换成一个类型为 PartialFunction[Any, T] 的对象。
  * 其中类型 T 是 => 右面的表达式的结果类型。
  *
  * 注意：消息传递的过程是异步的，你不会知道它会以什么样的顺序到达，在设计的时候应该考虑到不要依赖消息的投递顺序。
  * 注意：如果 receive 方法没有收到消息，这个线程就会被阻塞，直到有可以匹配的消息传递过来。
  * 注意：“邮箱”可能会被无法匹配的消息占满，必要的时候需要添加 case _ => 来处理无效消息。
  * 注意：不要再不同的 Actor 中使用共享的对象。
  */
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
    case Msg(id, name) => // 最好接受消息的方式，使用模式匹配来接受 case class 对象中的数据。
      println(id + ":" + name)
    case _ => // 处理无效消息，避免“消息队列”被占满。
      println("Nothing to do!")
  }
}

object Demo20_1 extends App {

}
