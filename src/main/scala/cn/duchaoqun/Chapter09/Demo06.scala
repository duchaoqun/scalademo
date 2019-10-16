package cn.duchaoqun.Chapter09

import java.io.PrintWriter

object Demo06 extends App {
  val out = new PrintWriter("out.txt")

  for ( x <- 1 to 100 ){
    out.println(x)
  }
  out.close()
}
