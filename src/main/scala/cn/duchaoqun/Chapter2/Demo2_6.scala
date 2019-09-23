package cn.duchaoqun.Chapter2

/**
  * 在 Scala 里面，对循环的使用并没有其他语言那么频繁。
  *
  * 在 Scala 没有 “for(i = 1, i < 10 , i++)” 这样的循环结构。
  *
  * 在 Scala 中 for 具体能取到什么内容，取决后面表达式的类型 (String 就是每个字符，集合类型就是每个对象)。
  *
  */
object Demo2_6 extends App {

  // 最基本中的 for 循环结构，表示：从 [1 - 10] 的 Range 中循环取出内容，赋值给 x ，然后再方法体执行相关逻辑。
  // “ <- ” 是提取符号，提取对象里面的内容。
  for (i <- 1 to 10) {
    println(i)
  }

  // 用法：遍历数组中的对象
  val strArray = Array("Scala", "Java", "Python")
  for (x <- strArray.indices) {
    println(strArray(x))
  }


  // 高级的for, 使用<- 来定义一个生成器，实际上是两个循环过程
  for (i <- 1 to 3; j <- 1 to 3) {
    print((10 * i + j) + " ")
  }

  // 使用生成器，带守卫的生成器，留意 if 之前没有分号。
  for (i <- 1 to 3; j <- 1 to 3 if i != j) {
    print((10 * i + j) + " ")
  }

  // 使用生成器，引入可以在循环中使用的变量 from
  for (i <- 1 to 3; from = 4 - i; j <- from to 3) {
    print((10 * i + j) + " ")
  }

  // 案例:for中添加if条件守卫,用于限制for循环(优化for循环,或者用于跳出for循环)
  var flag1 = true
  var sum1 = 0
  for (i <- 0 to 10 if flag1) {
    sum1 = sum1 + i
    if (i == 5) flag1 = false
  }

  // 案例:使用return跳出循环.想要跳出for循环,可以使用if条件守卫,也可以使用return关键字.
  def sum2(): Unit ={
    var sum2 = 0
    for (i <- 0 to 10) {
      sum1 = sum1 + i
      if (i == 5) return // return 是方法级别的,这里需要注意.
    }
  }

  // 使用推导式，循环构造一个集合，引入可以在循环中使用的变量from
  val vector1 = for (i <- 1 to 10) yield i % 3
  println(vector1)

  // 根据习惯，你也可以使用花括号来写如下内容。
  for {
    i <- 1 to 3
    from = 4 - i
    j <- from to 3
  } {
    println("Something")
  }


  val list = List(1,2,3,4,5)

  // for推倒式.
  // for循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合
  // 针对每一次for循环的迭代, yield会产生一个值, 被循环记录下来 (内部实现上,像是一个缓冲区).
  // 当循环结束后, 会返回所有 yield 的值组成的集合
  // 返回集合的类型与被遍历的集合类型是一致的
  val a = for (i <- 1 to 10) yield i % 3
  println(a.getClass)
  println(a)

  val b = for ( i <- list) yield i*2
  println(b.getClass)
  println(b)
}
