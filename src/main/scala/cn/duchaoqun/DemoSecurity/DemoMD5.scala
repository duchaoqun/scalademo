package cn.duchaoqun.DemoSecurity

import cn.duchaoqun.util.Security

/**
  * 计算一个文件的 MD5 值
  */
object DemoMD5 extends App {

  val md5 = Security.computeFileMD5Hash("C:\\Users\\Chris\\Pictures\\2019091201.jpg")
  println(md5)

  val strMd5 = Security.computeStringMD5Hash("root123")
  println(strMd5)

}
