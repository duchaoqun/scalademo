package cn.duchaoqun.Chapter05

object Demo12 extends App {
  // 返回类型：Nothing，示意应用程序非正常终止。
  @deprecated("Use `sys.error(message)` instead", "2.9.0")
  def error(message: String): Nothing = sys.error(message)

  // 返回类型：sys.error返回的类型是Nothing，他是所有类型的子类，所以此if表达式的类型就还是Int。
  def divide2(x: Int, y: Int):Int = {
    if (y != 0) x / y else sys.error("Cannot divide by Zero")
  }
}
