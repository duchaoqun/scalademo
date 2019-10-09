package cn.duchaoqun.Chapter12

object Demo15 extends App {
  // 高阶函数 foreach ，将一个函数应用到集合中的所有元素，没有返回结果。
  (1 to 9).map( "*" * _) foreach(println(_))
}
