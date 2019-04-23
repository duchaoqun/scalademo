package info.aoye.Chapter2

/**
  * 2.1 条件表达式
  */
object Demo2_1 extends App {
  val x = 1
  // 可以使用条件表达式初始化一个val对象
  //Note： 在Scala中每个表达式都有一个类型，上面的表达式就是Int类型。
  val test1 = if (x > 100) 1 else 0
  //Note: 混合类型，一个分支是String另外一个是Int类型，结果是共有的父类型 Any。
  val test2 = if (x > 100) "Bigger then 100" else 0

  //Note：如下两个是等价的，()表示的是Unit类型，代表什么都没有。
  val test3_1 = if (x > 100) 1
  val test3_2 = if (x > 100) 1 else ()
}
