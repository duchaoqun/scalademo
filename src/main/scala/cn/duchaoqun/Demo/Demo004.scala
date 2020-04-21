package cn.duchaoqun.Demo

object Demo004 extends App {

  // abstract class
  abstract class Amount

  // 创建两个扩展常规类(非样例类)的样例类
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount

  // 你也可以有针对单例的样例类
  case object Nothing extends Amount

  // 当我们有一个类型为 Amount 的对象时，我们可以用模式匹配来匹配到它的类型，并将属性值绑定到变量。
  //  amt match {
  //  样例类的实例使用()
  //    case Dollar(v) => "$" + v
  //    case Currency(_,u) => "On noes, I got " + u
  //  样例对象不使用圆括号
  //    case Nothing => ""
  //  }


  // 当你声明一个样例类时，有如下几件事会自动发生：
  // 1. 主构造器中的参数类型都是 val，除非你显示的使用var 来修饰（不推荐）。
  // 2. 样例类默认存在一个伴生对象，可以直接使用 apply 方法来创建对象。
  // 3. 默认提供unapply 方法，可以让 match case 工作。
  // 4. 将默认生成 toString equals hashCode 和 copy 方法（除非你显示的定义它们）

  // 除了上述内容，样例类和其他类完全一样，可以添加字段，扩展它们等等。



  val amt = Currency(12.34, "EUR")

  // 样例类的 copy 方法创建一个与现有对象值相同的新对象。
  val price1 = amt.copy()               // Currency(12.34, "EUR")

  // 这个方法本身并不是很有用，毕竟Currency本身是不可变的，我们完全可以共享这个对象。
  // 不过你可以使用带名参数来修改某些属性值。
  val price2 = amt.copy(value = 23.45)  // Currency(23.45, "EUR")
  val price3 = amt.copy(unit = "CHF")   // Currency(12.34, "CHF")
}
