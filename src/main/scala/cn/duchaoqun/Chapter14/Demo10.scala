package cn.duchaoqun.Chapter14

object Demo10 extends App {

  // 样例类经常被用于嵌套结构

  // 例如，某个商店销售的物品。有时我们会将物品捆绑在一起打折出售。

  abstract class Item

  case class Article(description: String, price: Double) extends Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  // 在不使用 new 关键字的情况下，我们很容易地给出嵌套对象定义：
  val b1 = Bundle("Father;s day special", 20.0, Article("Scala for the impatient", 39.95))
  val b2 = Bundle("Anchor Distillery Sampler", 10.0, Article("Old Potrero Straight Rye Whisky", 79.95), Article("Junipero Gin", 32.95))

  // 模式可以匹配到特定的嵌套

  b1 match {
    // 将descr 绑定到 Bundle 的第一个 Article 的 description 字段
    case Bundle(_, _, Article(descr, _), _*) => println(descr)
    // 也可以使用 @ 表示法，将 Bundle 的第一个 Article 绑定到 art 变量，其余的绑定到 rest 变量。
    case Bundle(_, _, art@Article(_, _), rest@_*) => println(art.description)
  }

  // 作为该特性的一个应用，一下是计算某 Item 价格的函数：
  def price(it: Item): Double = it match {
    case Article(_, p) => p
    case Bundle(_, disc, its@_*) => its.map(price _).sum - disc
  }

}
