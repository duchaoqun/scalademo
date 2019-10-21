package cn.duchaoqun.Chapter17

object Demo05 extends App {

  // 试图界定 T<% V 要求必须存在一个从 T 到 V 的隐式转换。
  // 上下文界定的形式为 T：M ，其中 M 是另外一个泛型类，他要求必须存在一个类型为 M[T] 的“隐式值”。
  class Pair1[T: Ordering]


  // 上述定义要求必须存在一个类型为 Ordering[T] 的隐式值，该隐式值可以被用在该类的方法中，当你声明一个使用隐式值的方法时。
  // 需要添加一个隐士参数。
  class Pair2[T: Ordering](val first: T, val second: T) {
    def smaller(implicit ord: Ordering[T]): T = {
      if (ord.compare(first, second) < 0) first else second
    }
  }

}
