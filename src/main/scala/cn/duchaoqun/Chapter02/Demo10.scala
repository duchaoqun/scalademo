package cn.duchaoqun.Chapter02

/**

  */
object Demo10 extends App {

  def box(s: String) {
    val border = "-" * s.length + "--\n"
    println (border + "|" + s + "|\n" + border)
  }

  box("Scala")
}
