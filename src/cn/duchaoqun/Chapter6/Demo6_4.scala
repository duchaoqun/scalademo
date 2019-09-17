package cn.duchaoqun.Chapter6

/**
  * 6.4 apply方法
  * 通常使用一个apply方法返回伴生类的对象。
  */
object Demo6_4 extends App {

  val arr1 = Array(1,2,3,4,5) // 这个Array就是调用的apply方法（在使用嵌套表达式的时候这样很方便）

  // 注意Array(100) 和 new Array(100)是完全不一样的， 前一个只有一个元素100，后一个包含100个null元素。

  def aa = Account.apply // 这样就可以构造对象了。
}


class Account{

}

object Account {
  def apply:Account = new Account()
}