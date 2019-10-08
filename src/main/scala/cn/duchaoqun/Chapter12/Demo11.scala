package cn.duchaoqun.Chapter12

object Demo11 extends App {

  // 高阶函数 map 将一个函数应用到集合中的所有元素，然后返回结果。
  (1 to 9).map( 0.1 * _)

  // 高阶函数 foreach ，将一个函数应用到集合中的所有元素，没有返回结果。
  (1 to 9).map( "*" * _) foreach(println(_))


  // 高阶函数 filter，过滤集合中的元素，返回匹配的结果。
  (1 to 9).filter( _ % 2 == 0).foreach(println(_))

  // 高阶函数 reduceLeft，接受一个二元函数，处理集合中前两个元素，处理所得的一个结果作为与第三个元素继续处理，依次到最后一个元素。
  // 每个下划线分别代表一个参数
  val res1 = (1 to 9 ).reduceLeft(_ * _)
  val res2 = (1 to 9).product // 针对数字，效果同上。

  // 高阶函数 sortWith

}
