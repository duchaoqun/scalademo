package cn.duchaoqun.Chapter2

/**
  * 知识点：Scala 中的 if 条件表达式是有返回值的，可以把他的值赋给一个对象。
  */
object Demo2_1 extends App {
  //
  val x = 1

  // test1 的类型是 Int 类型，可以使用条件表达式初始化一个 val 对象，结果类型是 Int 类型。
  val test1 = if (x > 100) 1 else 0

  // test2 的类型是混合类型，一个分支是String另外一个是Int类型，结果是共有的父类型 Any。
  val test2 = if (x > 100) "Bigger then 100" else 0

  // 如下两个是等价的，()表示的是Unit类型，代表什么都没有。
  val test3 = if (x > 100) 1
  val test4 = if (x > 100) 1 else ()

  // 条件表达式 if 可以进行类型推导，一般过程就是依据变量的类型进行推导，(可以省略类型的书写)。
  // 如果条件表达式 if 没有 else 部分，结果类型就变成 Any 类型，不建议这么写。
  var age = 10
  // result1 的类型是 String 类型，因为两个分支都是 String 类型。
  var result1 = if (age > 25) "Worker" else "Student"
  // result2 的类型是 Any，因为两个分支一个是 String，一个 Int，所以类型是两者的公共类型Any。
  var result2 = if (age > 18) "Adult" else 1
  // result3 的类型是 Any，因为表达式省略了" else ()"，两个分支分别是 String 类型和 Unit 类型。
  var result3 = if (age > 18) "Adult"

  // Option 类型是处理业务逻辑需要的类型，一般使用如下写法：
  val isEventLogEnabled = true
  if (isEventLogEnabled) {
    Some("Log")
  } else {
    None
  }

  // 条件表达式 if 可以用在 for 循环等其他控制结构中。
  for (i <- 0 to 10 if i%2 == 0) {
    println(i)
  }
}
