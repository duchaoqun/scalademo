package info.aoye.Chapter9

import java.io.PrintWriter

/**
  * 9.6 写入文本文件
  * Scala默认没有对写入文件的支持。
  * 需要写入到文件，可以使用java.io.PrintWriter
  */
object Demo9_6 extends App {
  val out = new PrintWriter("out.txt")

  for ( x <- 1 to 100 ){
    out.println(x)
  }
  out.close()
}
