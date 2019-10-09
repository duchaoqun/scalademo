package cn.duchaoqun.Chapter6

/**
  * 每个 Scala 程序必须从一个对象的 main 方法开始
  * Main 方法的类型是 Array[String] -> Unit(仅带一个参数 Array[String]，且返回类型为 Unit 的单例对象)
  * 这里的 main 是方法，因为他不具备函数特征。
  * 按照目前 OS 的原理，main 方法都是运行在主线程中的。
  *
  * OS 的运行分为 Kernel Space 和 User Space，应用程序是运行在 UserSpace 中的，Scala 所在的进程一般都是透过OS Fork出来的，
  * 被 Fork 出来的应用程序进程默认会有主线程，而我们的 main 方法就是默认在主线程中的。
  */
object Demo05{
  def main(args: Array[String]): Unit = {
    println("Hello Scala")
  }
}


/**
  * Scala 程序的入口点也可以直接继承App特质，它帮我们完成的 main 的编写，获取命令行参数直接使用args即可。
  */
object Demo6_5_1 extends App{
  println("Hello Scala")
  println(args)
  println(this.args(0))
  println(this.args(1))
}

