package cn.duchaoqun.Chapter18

object Demo02 extends App {

  import scala.collection.mutable.ArrayBuffer

  // 嵌套类从属于包含它的外部对象。
  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]()
    }

    private val members = new ArrayBuffer[Member]()

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

  // 每个 Network 对象都有它自己的 Member 类。
  // 假设如下两个 Network 对象。
  val chatter = new Network
  val myFace = new Network
  // 现在 net_1.Member 和 net_2.Member 是两个不同的类。
  // 你不能将其中一个 Network 的 Member 成员添加到另外一个 Network 对象。

  val fred = chatter.join("Fred")
  val barney = myFace.join("Barney")
  // fred.contacts += barney  // 这里是错误的。

  // 如果你不希望有这个约束，你应该吧 Member 类直接挪到 Network 类之外，一个好的地方可能是 Network 的伴生对象中。

  // 如果你要的就是细粒度的累，只是偶尔想使用更为松散的定义，那么可以用“类型投影” Network#Member，意思是“任何Network的Member”

  class NetworkNew {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[NetworkNew#Member]()
    }
  }
  // 类似 Network#Member这样的类型投影并不会被当作“路径”，你也无法引入它。
}
