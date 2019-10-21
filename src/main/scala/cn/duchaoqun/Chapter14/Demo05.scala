package cn.duchaoqun.Chapter14

object Demo05 extends App {

  // 对于数组的匹配
  val array = Array(0, 1, 2, 3, 4, 5)
  val res1 = array match {
    case Array(0) => "0" // 匹配包含 0 的数组
    case Array(x: Any, y: Any) => x + " " + y // 匹配包含两个任意元素的数组。
    case Array(0, _*) => "0 ..." // 匹配任何以 0 开始的数组。
    case _ => "Something else!" // 匹配其他内容。
  }

  println(res1)

  // 对于列表的匹配
  val list = List(1, 2, 3, 4, 5)
  val res2 = list match {
    case 0 :: Nil => "0"
    case x :: y :: Nil => x + "" + y
    case 0 :: tail => "0 ..."
    case _ => "Something else!"
  }

  // 对于元组的匹配
  val tuple1 = 1 -> 100
  val res3 = tuple1 match {
    case (0, _) => "0 ..."
    case (y: Int, 0) => y + " 0"
    case _ => "Neither is 0"
  }

}
