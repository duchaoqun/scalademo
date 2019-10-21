package cn.duchaoqun.Chapter14

object Demo09 extends App {

  // 如果 unapply 方法产出一个对偶，则你可以在 case 语句中使用中置表达法，尤其是对于有两个参数的样例类。

  abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount

  val dollar1 = Dollar(100.00)



}
