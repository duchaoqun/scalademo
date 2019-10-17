package cn.duchaoqun.Chapter11

object Demo06 extends App {
  // 在 Scala 中所有的操作符都是左结合的，如下先计算 20-2 ，然后再计算18 - 9，根据操作符优先级，结果赋值给 a
  val a = 20 - 2 - 9
  println(a)

  // 用于构造列表的“::”操作符是右结合的。
  // 首先 2 :: Nil 构造一个列表，然后它作为尾部拼接到以 1 为头部的列表后面。
  // 右结合的二元操作符实际上是其第二个参数的方法，例如： 2;;Nil  等于 Nil.::(2) ，将 2 添加到列表头部。
  // 注意：列表对象才有“::”方法。
  val list_1 = 1 :: 2 :: Nil
  println(list_1)
}
