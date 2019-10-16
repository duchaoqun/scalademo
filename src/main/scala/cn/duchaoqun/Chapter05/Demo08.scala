package cn.duchaoqun.Chapter05

import scala.collection.mutable.ArrayBuffer

object Demo08 extends App {
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

  val chatter = new Network
  val myFace = new Network
}

