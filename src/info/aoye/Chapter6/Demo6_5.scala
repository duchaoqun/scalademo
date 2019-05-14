package info.aoye.Chapter6

/**
  * 6.5 应用程序对象（main方法）
  * 每个Scala程序必须从一个对象的main方法开始，这个方法的类型是Array[String] -> Unit
  */
object Demo6_5{
  def main(args: Array[String]): Unit = {
    println("Hello Scala")
  }
}


/**
  * 也可以直接继承App特质，它帮我们完成的main的编写，获取命令行参数直接使用args即可。
  *
  * scala -Dscala.time Hello Fred ，
  */
object Demo6_5_1 extends App{
  println("Hello Scala")
  println(args)
}

