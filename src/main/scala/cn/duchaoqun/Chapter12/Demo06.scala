package cn.duchaoqun.Chapter12

object Demo06 extends App {
  // 可变长的参数
  // 函数得到的是一个Seq类型的参数?,包含多个Int值. todo: 这里是Seq 还是Array需要深入学习.
  def sum(args: Int*): Int = {
    println(args.getClass)
    var result = 0
    for (x <- args) result += x
    result
  }
  //注意: 如果函数接收一个整体,则在调用的时候需要加 : _* 将输入作为一个整体处理,例如(1 to 5: _*)
  println(sum(1 to 1000: _*))

  // 从左到右拼接字符串
  def method(strings: String*): String = {
    // strings 的类型是Seq[String]
    strings.reduceLeft(_ + _)
  }
  method("Scala","Spark","Java","J2EE")

  // 从左到右计算，累加
  def method(values: Int*): Int = {
    values.reduceRight(_ + _)
  }
  method(1 to 10:_*) //注意：此处的 :_*是将一个Range转成一个Seq，使用的是其中的值
}
