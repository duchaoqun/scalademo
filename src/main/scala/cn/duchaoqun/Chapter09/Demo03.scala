package cn.duchaoqun.Chapter09

import scala.io.Source

object Demo03 extends App {

  // 假如我们有一个包含浮点数的文件
  val vectors = Source.fromFile("D:\\Data\\Vectors.txt", "UTF-8")

  // 数字是按照空格分隔开的
  val tokens = vectors.mkString.split("""\s+""")

  // 将数字都读取到数组中
  val numbers1 = for (x <- tokens) yield x.toDouble
  val numbers2 = tokens.map(_.toDouble)

  // 提示，你总是可以使用 java.util.Scanner 类来处理同时包含文本和数字的文件。
}
