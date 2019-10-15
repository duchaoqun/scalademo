package cn.duchaoqun.Chapter05

object Demo01 extends App {

  class Counter {
    // 必须初始化属性值，私有的属性，外部看不到。
    private var age = 0

    // 方法(过程)默认是公有的
    def increment() { age += 1 }

    // 定义一个取值方法
    def currentAge: Int = age
  }

  val myCounter = new Counter
  // 调用无参方法可以省略小括号
  myCounter.increment()         // 对于改变对象状态的一般写上小括号。
  println(myCounter.currentAge) // 对于取值方法，可以省略小括号。
}

