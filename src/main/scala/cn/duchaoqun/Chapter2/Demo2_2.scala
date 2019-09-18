package cn.duchaoqun.Chapter2

/**
  * 2.2 语句终止
  * 在Scala中，行的结尾不需要使用分号。
  */
object Demo2_2 extends App {
  var x = 1
  var y = 2
  var z = 0
  //Note: 当两条语句写在一行的时候，中间需要使用分号分隔，我觉得这样写不好。
  if (y > 0) { z = x * y ; y -= 1 }

  //Note: 通常在一行写不下的时候，我们使用//操作符来告诉编译器，这里代码进行了换行。
  val a = 1 + 2 + 3 + 4 //
  + 5 + 6
}
