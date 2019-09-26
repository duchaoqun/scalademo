package cn.duchaoqun.Chapter17


/**
  * 定义一个带有两个类型参数 T 和 S 的类
  * @param first  第一个参数
  * @param second 第二个参数
  * @tparam T     类型参数
  * @tparam S     类型参数
  */
class Pair[T, S](first: T, second: S){
  // todo : 在类的定义中，你可以用类型参数来定义变量、方法参数，以及返回值的类型。

}


// 带有一个或者多个“类型参数”的类是“泛型的”

object Demo17_1 extends App {

  // 如果你把“类型参数”换成实际的类型(如 Int 类型 String 类型)，将得到一个普通的类，比如Pair[Int,String]

  // Scala 会从构造参数推断出这个实际类型
  val p1 = new Pair(1,"Scala")  // 这是一个Pair[Int,String]
  // 你也可以自己指定类型。
  val p2 = new Pair[Any,Any](1,"Scala")

}


