package cn.duchaoqun.Chapter09

import java.io.{File, FileInputStream}

object Demo05 extends App {
  val filename = "*****"
  val file = new File(filename)
  val in = new FileInputStream(file)
  val bytes = new Array[Byte](file.length.toInt)
  in.read(bytes)
  in.close()

  // bytes 数组中存放了所有的二进制内容
}
