package cn.duchaoqun.Chapter2

/**
  * 2.6 高级for循环和for推导式
  */
object Demo2_6 extends App {
  // 使用生成器
  for (i <- 1 to 3;j <- 1 to 3){
    print((10 * i + j) + " ")
  }

  // 使用生成器，带守卫的生成器，留意if之前没有分号。
  for (i <- 1 to 3;j <- 1 to 3 if i != j){
    print((10 * i + j) + " ")
  }

  // 使用生成器，引入可以在循环中使用的变量from
  for (i <- 1 to 3; from = 4 - i; j <- from to 3){
    print((10 * i + j) + " ")
  }

  // 使用推导式，循环构造一个集合，引入可以在循环中使用的变量from
  val vector1 = for (i <- 1 to 10) yield i % 3
  println(vector1)

  // 根据习惯，你也可以使用花括号来写如下内容。
  for {
    i <- 1 to 3
    from = 4 - i
    j <- from to 3
  }{
    println("Something")
  }
}
