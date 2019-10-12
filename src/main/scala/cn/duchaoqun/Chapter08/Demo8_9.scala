package cn.duchaoqun.Chapter08

/**
  * 8.9 抽象字段
  */
object Demo8_9 extends App {
  // 可以随时使用匿名类型来定制抽象类
  val tmp1 = new Demo8_9_1 {
    override val id: Int = 123
    override var name: String = "Java"
  }
}

abstract class Demo8_9_1{
  val id:Int  // 抽象字段，就是没有初始化值的字段，带有getter方法
  var name:String // 抽象字段，带有 getter 和 setter方法
}

/**
  * 使用这个抽象类
  * @param id 实现抽象类中的id
  */
class Demo8_9_2(val id:Int) extends Demo8_9_1{
  override var name: String = "Java"
}