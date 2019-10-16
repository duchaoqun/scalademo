package cn.duchaoqun.Chapter06

object Demo05{
  object Demo6_5_1 extends App{
    println("Hello Scala")
    println(args)
    println(this.args(0))
    println(this.args(1))

    // 获取输入参数
    args.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    println("Hello Scala")
  }
}




