package info.aoye.Chapter2

/**
  * 2.10 过程
  *
  * Scala 对于不返回值的函数有特殊的表示方法，如果函数体包含在花括号中但是没有前面的=号，那么返回类型就是Unit。
  * 这样的函数被称为过程（procedure），过程不返回值，我们调用它仅仅是为了它的副作用。
  */
object Demo2_10 extends App {

  def box(s: String) {
    val border = "-" * s.length + "--\n"
    println (border + "|" + s + "|\n" + border)
  }

  box("Scala")
}
