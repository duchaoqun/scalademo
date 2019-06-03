package info.aoye.Chapter10

/**
  * 10.5 叠加在一起的特质
  *
  * 你可以为类和对象添加多个相互调用的特质，从最后一个开始执行？ 待深入研究
  */
object Demo10_5 extends App {
  val a = new Demo10_5_4 with Demo10_5_2 with Demo10_5_3
  val b = new Demo10_5_4 with Demo10_5_3 with Demo10_5_2
}


trait Demo10_5_1 {
  def log(msg: String) {
    println(msg)
  }
}

trait Demo10_5_2 extends Demo10_5_1 {
  override def log(msg: String): Unit = {
    super.log(s"Demo 10_5_2 $msg")
  }
}

trait Demo10_5_3 extends Demo10_5_1{
  override def log(msg: String): Unit = {
    super.log(s"Demo 10_5_3 $msg")
  }
}

class Demo10_5_4 extends Demo10_5_1 {
  log("Demo10_5_4")
}
