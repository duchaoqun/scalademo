package cn.duchaoqun.Chapter24

object Demo01 extends App {
  // 使用 Java 的类库。
  import java.lang.Math.sqrt
  println(sqrt(4)) // 获取平方根

  // scala API
  println(math.log(8))
  println(math.log10(8))
  println(math.random * 100.toInt) //random number 随机数

  /**
    * 计算阶乘
    *
    * @param n 整数
    * @return
    */
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  /**
    * 计算累加
    * @param n 整数
    * @return
    */
  def sum(n: Int): Int = {
    if (n == 0) 0
    else n + sum(n - 1)
  }

  // 四舍五入取整
  Math.ceil(11.2/2).toInt
}
