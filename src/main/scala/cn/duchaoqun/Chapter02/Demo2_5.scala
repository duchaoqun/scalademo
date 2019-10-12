package cn.duchaoqun.Chapter02

/**
  * 2.5 循环
  */
object Demo2_5 extends App {
  var x = 10
  var y = 2
  var z = 0

  // Scala 有和其他语言类型的while和do循环。
  while (x > 1) {
    z = x * y
    x -= x
  }

  // Scala 中没有 for(i = 1; i< n : i++)这样的结构
  // 如下for结构中，x前没有var和val指定，这个变量的类型是集合元素的类型，循环变量的作用域一直到循环结束。
  for (x <- 1 to 10){  // 1 to 10 返回一个集合，方法会包含上限10
    println(x)
  }

  for (x <- 1 until 10){ // 1 until 10 返回一个集合，不含上限10，这个常用。
    println(x)
  }

  // 说明：Scala并没有提供break和continue语句来退出循环。
  // 1. 使用Boolean型的控制变量。
  // 2. 使用嵌套函数，可以从函数中return。
  // 3.

  import scala.util.control.Breaks._
  breakable {
    for (x <- 1 to 10){
      if (x > 5) break()  // 退出块，这里是通过抛出异常和捕获异常实现的，高校的Scala程序，应该尽量避免使用这种方式。
      println(x)
    }
  }

  // Demo A: Use flag parameter to break
  var flag = true
  while (flag) {
    for (item <- "Spark") {
      println(item)
      if (item == 'r') flag = false  // 这里会完成一次循环才能跳出,逻辑有些问题.
    }
  }

  // Demo B: 使用breakable来跳出循环
  import scala.util.control.Breaks._
  breakable{
    while (flag) {
      for (item <- "Spark") {
        println(item)
        if (item == 'r') break
      }
    }
  }

  // Demo C: 感觉这里使用for更合适. Feel for is better.
  var int1 = 0
  while (int1 < args.length) {
    println(args {
      int1
    })
  }
}
