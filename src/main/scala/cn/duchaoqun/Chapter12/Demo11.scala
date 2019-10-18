package cn.duchaoqun.Chapter12

object Demo11 extends App {

  // 高阶函数 map 将一个函数应用到集合中的所有元素，然后返回结果集合。
  val res1 = (1 to 9).map( 0.1 * _)

  // 定义一个 Person 类。
  case class Person(name: String, friends: List[String])

  // 构建三个 Person 对象，每个人都有不同的朋友。
  val p1 = Person("John", List("JohnFriendA"))
  val p2 = Person("Chris", List("ChrisFriendA", "ChrisFriendB"))
  val p3 = Person("Mary", List("MaryFriendA", "MaryFriendB", "MaryFriendC"))

  // 构建一个 Person 列表.
  val listPerson: List[Person] = List(p1, p2, p3)

  // map 将集合中的每个对象的朋友列表返回来
  // 返回的是List(List(JohnFriendA), List(ChrisFriendA, ChrisFriendB), List(MaryFriendA, MaryFriendB, MaryFriendC))
  def map_1() = {
    val res = listPerson.map(x => x.friends)
    res
  }

}
