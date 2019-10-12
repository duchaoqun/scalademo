package cn.duchaoqun.Chapter08

/**
  * 8.7 匿名子类
  */
object Demo8_7 extends App {

  // 你可以通过包含带有定义或者重写的代码块的方式创建一个匿名的子类
  // 这将会创建出一个结构类型对象，该类型标记为Demo8_7_1{def vars:String}
  val alien: Demo8_7_1 = new Demo8_7_1(123) {
    def vars = "Scala"
  }

  def meet(p: Demo8_7_1{def vars:String}): Unit ={
    println(p.vars)
  }
}


class Demo8_7_1(id:Int){

}