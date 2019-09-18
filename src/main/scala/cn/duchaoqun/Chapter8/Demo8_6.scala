package cn.duchaoqun.Chapter8

/**
  * 8.6 重写字段
  */
object Demo8_6 extends App {

}


abstract class Demo8_6_1{
  def id:Int // 每个对象都有一个以某种方式计算出来的id
}

class Demo8_6_2(override val id:Int) extends Demo8_6_1{
  // def 关键字只能重写另外一个def
  // val 能重写另一个val 或者不带参数的 def
  // var 只能重写另外一个 abstract var
}

//