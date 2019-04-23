package info.aoye.Chapter2

import java.text.MessageFormat

/**
  * 2.9 变长参数
  */
object Demo2_9 extends App {

  // 定义一个函数，接收的参数的长度是可变化的。
  // 函数得到的是一个Seq类型的参数。
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

  println(sum(1, 2, 3, 4))

  // 如果你已经有一个区间，不能直接使用上面的方法。
  val a = 1 to 5
  // 你需要告诉编译器将这个区间转换成一个序列。这里使用a: _* 来实现。
  println(sum(a: _*))

  // 递归实现的累加，args.head 是第一个元素，args.tail是除去第一个元素意外的其他内容。
  def recursiveSum(args: Int*): Int = {
    if (args.isEmpty) 0
    else args.head + recursiveSum(args.tail: _*)
  }

  // 注意：当你调用变长参数且参数类型为Object的Java方法时，如PrintStream.printf或者MessageFormat.format
  // 你需要手动对基本类型进行转换。
  val str = MessageFormat.format("The answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])
  println(str)
}
