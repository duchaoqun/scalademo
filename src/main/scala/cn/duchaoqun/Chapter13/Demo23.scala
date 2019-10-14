package cn.duchaoqun.Chapter13

object Demo23 extends App {
  val strbd1 = new scala.collection.mutable.StringBuilder
  //添加单个字符
  strbd1 += 'a'

  //添加多个字符, 返回的是当前的这个StringBuilder对象. 在后面也可以处理这个字符串
  strbd1 ++= "bcdef".dropRight(1)

  //转换成字符串
  println(strbd1.mkString)
}
