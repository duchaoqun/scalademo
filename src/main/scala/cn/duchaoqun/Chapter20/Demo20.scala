package cn.duchaoqun.Chapter20

/**
  * 官方文档：https://doc.akka.io/docs/akka/2.5/actors.html
  *
  * 在 2.10 以后的版本，Actor被独立出来发布，需要添加如下引用才可以使用。
  * libraryDependencies += "org.scala-lang" % "scala-actors" % "2.11.8"
  *
  * 在 2.13.0 版本中，需要使用如下引用方式
  * https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
  * libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.0-M7"
  *
  * Actor 通过尽可能避免锁和共享状态, Actor 使得我们能够更容易地设计出正确, 没有死锁或争用状况的程序。
  * Actor 可以更方便的实现多线程编程, Actor trait 类似于 Java 中的 Thread 和 Runnable 是基础的多线程基类和接口。
  */
object Demo20 {}
