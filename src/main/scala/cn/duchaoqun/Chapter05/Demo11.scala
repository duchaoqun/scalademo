package cn.duchaoqun.Chapter05

object Demo11 extends App {

  abstract class Amount
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount

  val amt = Currency(12.34, "EUR")

  // 样例类的 copy 方法创建一个与现有对象值相同的新对象。
  val price1 = amt.copy()               // Currency(12.34, "EUR")

  // 这个方法本身并不是很有用，毕竟Currency本身是不可变的，我们完全可以共享这个对象。
  // 不过你可以使用带名参数来修改某些属性值。
  val price2 = amt.copy(value = 23.45)  // Currency(23.45, "EUR")
  val price3 = amt.copy(unit = "CHF")   // Currency(12.34, "CHF")

}
