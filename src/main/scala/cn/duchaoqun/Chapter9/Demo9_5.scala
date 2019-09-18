package cn.duchaoqun.Chapter9

import java.io.{File, FileInputStream}

/**
  * 9.5 读取二进制文件
  * Scala 并没有提供读取二进制文件的方法。
  * 我们需要使用Java的类库。
  */
object Demo9_5 extends App {
  val filename = "*****"
  val file = new File(filename)
  val in = new FileInputStream(file)
  val bytes = new Array[Byte](file.length.toInt)
  in.read(bytes)
  in.close()

  // bytes 数组中存放了所有的二进制内容
}
