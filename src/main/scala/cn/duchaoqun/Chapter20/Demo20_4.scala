package cn.duchaoqun.Chapter20


/**
  * 当计算被拆分成不同的部分，分别在不同的Actor中执行的时候，每个部分的计算结果需要收集到一起。
  * Actor 可以将结果存放到一个线程安全的数据结构中，比如一个并发的 HashMap，但是 Actor 模型并不鼓励使用共享数据。
  * 所以当 Actor 结果计算完成后，需要向其他 Actor 发送消息。
  *
  * 一个 Actor 是如何知道应该向哪里发送计算结果呢？ 这里有几个设计选择：
  *
  * 1. 可以有一些全局的 Actor ，但是当 Actor 数量非常多的时候，这个方案的伸缩性并不好。
  *
  * 2. Actor 可以构造成带有指向一个或者多个 Actor 的引用。
  *
  * 3. Actor 可以接收带有指向另一个 Actor 引用的消息，在请求中提供一个 Actor 引用时一个很常见的做法。
  *    actor ! Compute(data, otherActorRef)
  *    这里的 otherActorRef 是另外一个 Actor 的引用，当计算完成的时候，应该调用这个 Actor。
  *
  * 4. Actor 可以返回消息给发送方，receive 方法会把 sender 字段设为当前消息的发送方。
  *
  *
  * 注意：当一个Actor持有另外一个Actor的引用时，它应该只用这个引用发送消息，不能用来调用其方法。
  *      如果这样做了，就违背了Actor模型的意义，它同时还可能引发争用问题（Actor 被设计出来要避免的问题）。
  */
object Demo20_4 extends App {

}
