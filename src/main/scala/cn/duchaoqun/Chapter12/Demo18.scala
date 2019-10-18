package cn.duchaoqun.Chapter12

object Demo18 extends App {

  // 定义一个Person类。
  case class Person(name: String, friends: List[String])

  // 构建三个 Person 对象，每个人都有不同的朋友。
  val p1 = Person("John", List("JohnFriendA"))
  val p2 = Person("Chris", List("ChrisFriendA", "ChrisFriendB"))
  val p3 = Person("Mary", List("MaryFriendA", "MaryFriendB", "MaryFriendC"))

  // 构建一个Person列表.
  val listPerson: List[Person] = List(p1, p2, p3)

  // flatMap 将集合第二层对象序列
  // def flatMap[B](f: (A) ⇒ GenTraversableOnce[B]): Array[B]
  val res = listPerson.flatMap(x => x.friends)
  println(res) // List(JohnFriendA, ChrisFriendA, ChrisFriendB, MaryFriendA, MaryFriendB, MaryFriendC)

  // 将所有的值串在一起，返回一个 List[String] 对象。
  val names = List("Scala", "Python", "Java")
  def ulcase(s: String) = Vector(s.toUpperCase, s.toLowerCase)
  names.flatMap(ulcase)
}
