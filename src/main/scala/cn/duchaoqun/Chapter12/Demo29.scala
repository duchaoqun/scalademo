package cn.duchaoqun.Chapter12

object Demo29 extends App {
  val pf: PartialFunction[Int, String] = {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
  }
  val pfFour: PartialFunction[Int, String] = {
    case 4 => "Four"
  }
  val pfFive: PartialFunction[Int, String] = {
    case 5 => "Five"
  }

  val pfNote: PartialFunction[String, String] = {
    case x if x == "Five" => "This is Five!!"
  }

  println(pf(1)) // 使用偏函数

  // isDefinedAt : 这个函数的作用是判断传入来的参数是否在这个偏函数所处理的范围内
  println(pf.isDefinedAt(5)) // 如果输入1 该偏函数可以处理就会返回true,其他不能处理的时候就返回false

  // orElse : 将多个偏函数组合起来使用, 效果类似case语句
  val newPf = pf orElse pfFour orElse pfFive
  println(newPf(5))

  // andThen: 相当于方法的连续调用，比如g(f(x))
  val newPf1 = pfFive andThen pfNote // 注意：pfFive的结果返回类型必须和 pfNote 的参数传入类型必须一致，否则会报错。
  println(newPf1(5))

  // pplyOrElse: 它接收 2 个参数, 第一个是调用的参数, 第二个是个回调函数. 如果第一个调用的参数匹配, 返回匹配的值, 否则调用回调函数.
  println(pfFive.applyOrElse(5, "Other"))
  println(pfFive.applyOrElse(3, { num: Int => s"Other + $num" })) //todo 这里是个很意思的写法.

  // 有些方法接受 PartialFunction 作为参数。
  // 例如 GenTraversable 特质的 collect 方法将一个偏函数应用到所有在该偏函数有定义的元素，并返回包含这些结果的序列。
  "-3+4".collect {
    case '+' => 1
    case '-' => -1
  } // Vector(-1,1)

}
