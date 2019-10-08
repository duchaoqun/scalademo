package cn.duchaoqun.Chapter12

object Demo05 extends App {
  // 函数名称和函数体之间有等号，用于返回一些内容。
  def functionA(name: String, age: Int): Int = {
    println("Name is: " + name + " , and Age is:"+ age)
    age
  }

  // 如果函数名称和函数体之间没有等号，
  // 那么该函数的返回值类型会推断失败(不是函数体最后一条语句的结果类型)，
  // 这个函数的结果类型是Unit，
  // 用于改变对象的状态。
  def functionB(name: String, age: Int) {
    println("Name is: " + name + " , and Age is:"+ age)
    age
  }

  println(functionA("Scala",100))
  println(functionB("Scala",100))
}
