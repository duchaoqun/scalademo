package cn.duchaoqun.Chapter11

/**
  * 11.4 赋值操作符
  *
  * 格式为： “操作符=”
  * 例如： a 操作符= b  ， 等于 a = a 操作符 b
  */
object Demo11_4 extends App {

  var a = 1
  var b = 1
  a += b
  println(a)

  // 注意:
  // <= >= != 不是赋值操作符
  // 以 = 号开头的符号不是赋值操作符（==、===、=/=）
  // 如果 a 有一个方法叫“操作符=”，那么该方法会被直接调用。
}
