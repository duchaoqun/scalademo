package cn.duchaoqun.Chapter13

import scala.collection.mutable

object Demo02 extends App {

  /*
   import scala.collection.Map               共同的父类，这个父类没有定义任何修改值得操作
   import scala.collection.immutable.Map  // 子类1：优先采取不可变的 Map
   import scala.collection.mutable.Map    // 子类2：可变的 Map 要谨慎使用

   */

  // Scala 优先采取不可变集合，scala.collection.Map 的伴生对象默认创建的是不可变的 Map
  val map1 = Map(1 -> "Scala") // class scala.collection.immutable.Map$Map1

  // 默认被引入的 scala 包中的集合类型默认是不可变的。
  // Predef 中所指向不可变特质的 类型别名 List Set Map 是默认不可变的。
  val map2 = Predef.Map(1 -> "Scala") // class scala.collection.immutable.Map$Map1

  // 当需要使用可变的 Map 的时候，需要补充前面的 mutable 包名称。
  val map3 = Map(2 -> "Scala") // class scala.collection.immutable.Map$Map1
  // 2.13.0 本版中貌似不用显示的导入包了(import scala.collection.mutable.Map)
  val map4 = mutable.Map(1 -> "Scala") // class scala.collection.mutable.HashMap


  /*
  * 如果有效的利用不可变的集合呢？
  * 关键在于基于老的集合创建出新的集合。
   */
  def digits(n: Int): Set[Int] = {
    if (n < 0) {
      digits(-n)
    } else if (n < 10) {
      Set(n)
    } else {
      digits(n / 10) + (n % 10)
    }
  }
}
