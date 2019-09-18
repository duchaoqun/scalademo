package cn.duchaoqun.Chapter5

import scala.collection.mutable.ArrayBuffer

/**
  * 5.8 嵌套类【L1】
  * 在Scala中你可以在任意的语法结构中嵌套任意的语法结构。你可以在函数中定义函数，在类中定义类。
  * 在Scala中每个实例都有它自己的Member类，就像属性一样，两个不同的对象包含的Member类是不相同的。
  */
object Demo5_8 extends App {
  val chatter = new Network
  val myFace = new Network
}

class Network {

  class Member(var name: String) {
    //val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
  // TODO: 类型投影
}