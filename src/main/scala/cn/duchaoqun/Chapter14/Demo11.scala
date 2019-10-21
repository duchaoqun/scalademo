package cn.duchaoqun.Chapter14

object Demo11 extends App {

  sealed abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
  // 密封类的所有子类都必须与该密封类在同一个文件中定义。

  // 如果某个类是密封的，那么在编译器所有子类就是可知的，因而编译器可以检查模式语句的完整性。
  // 从而让所有（同一个组）样例类都扩展某个密封的类或特质是个好的做法。
}
