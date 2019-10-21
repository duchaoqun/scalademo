package cn.duchaoqun.Chapter17

object Demo01 extends App {

  /**
    * 定义一个带有两个【类型参数】 T 和 S 的的
    *
    * @param first  第一个参数
    * @param second 第二个参数
    * @tparam T 类型参数
    * @tparam S 类型参数
    */
  class Pair[T, S](first: T, second: S) {
    // todo : 在类的定义中，你可以用类型参数来定义变量、方法参数，以及返回值的类型。

  }


  // 如果你把【类型参数】换成实际的类型(如 Int 类型 String 类型)，将得到一个普通的类，比如Pair[Int,String]

  // 创建对象的时候不指明【类型参数】，通过传入构造函数中实际的参数的类型，推断出这个实际返回值类型。
  val p1 = new Pair(1, "Scala") // 这是一个Pair[Int,String]
  // 在创建对象的时候指明【类型参数】为[Any, Any]
  val p2 = new Pair[Any, Any](1, "Scala")
  // 在创建对象的时候指明【类型参数】为[Int, Int]
  val p3 = new Pair[Int, Int](1, 2)


  /**
    * 举例
    * @param f 构造函数接受一个方法，该方法接受 T 类型并计算，然后返回 R 类型。
    * @tparam T 类型参数
    * @tparam R 类型参数
    */
  class By[T, R](f: T => R) {
    def by(x: T): R = f(x)
  }
}




