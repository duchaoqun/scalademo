package cn.duchaoqun.DemoBCrypt

import org.mindrot.jbcrypt.BCrypt

/**
  * 加密字符串
  */
object Demo_01 extends App {

  val password = "123456"

  val salt = BCrypt.gensalt(10)

  println("SALT:" + salt)

  val hash = BCrypt.hashpw(password ,salt)

  println("HASH:" + hash)

  val result = BCrypt.checkpw("123456" ,hash)

  println("RESULT:" + result)

}
