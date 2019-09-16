package info.aoye.DemoSecurity

import info.aoye.util.Security

/**
  * 计算一个文件的 MD5 值
  */
object DemoMD5 extends App {

  val md5 = Security.computeHash("C:\\Users\\Chris\\Pictures\\2019091201.jpg")
  println(md5)
}
