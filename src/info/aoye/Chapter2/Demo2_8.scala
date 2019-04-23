package info.aoye.Chapter2

/**
  * 2.8 默认参数和带名参数
  */
object Demo2_8 extends App {

  // 定义一个方法，指定三个参数，其中两个有默认参数值。
  def decorate(string: String, left: String = "[", right: String = "]"): Unit ={
    println(left + string + right)
  }

  // 调用的时候，如果你不指定默认参数值，就会使用默认的参数值。
  decorate("Scala")
  // 调用的时候，指定参数值，就会使用我们的参数值。
  decorate(string = "Scala",left = "<<<",right = ">>>")
}
