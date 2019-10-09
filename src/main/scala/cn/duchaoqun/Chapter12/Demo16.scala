package cn.duchaoqun.Chapter12

object Demo16 extends App {
  // 高阶函数 filter，过滤集合中的元素，返回匹配的结果。
  (1 to 9).filter( _ % 2 == 0).foreach(println(_))

  // filter 过滤, 接收一个判断, 进行过滤
  println((1 to 5).filter(_ % 2 == 0))
  println((1 to 5).filter( x => x % 2 == 0))
  // 在filter 中使用正则表达式
  val regex = """^([a-zA-Z]\d{6})""".r  // enables you to drop escaping \'s 让你逃脱\'s 的内容, 这个一个技巧, 待学习.
  val f = List("b111111").filter { s => regex.findFirstIn(s).isDefined }
}
