package cn.duchaoqun.Chapter21

import java.io.File

import scala.io.Source

/**
  * 21.2 利用隐式转换扩展现有类库的功能
  *
  * 如果你希望某个类具有某个方法，但是类库的作者却没有提供？
  * 一是你需要联系作者，让作者来添加新的功能。
  * 二是  * 就可以用隐式转换来实现。
  */
object Demo2 extends App {

  // 例如：你想将 File 对象添加一个直接转换成 String 类型的功能，原始的类库没有这个功能。
  val file = new File("test.txt")

  // 定义一个新的类型，参数是你需要扩展的类型对象。
  class RichFile(from: File){
    def read: String = Source.fromFile(from).mkString
  }

  // 定义隐式转换
  implicit def file2RichFile(from: File): RichFile = new RichFile(from)

  // 在具体调用的时候会被自动转换成 RichFile 类型，然后就能调用你自己添加的 read 方法了。
  println(file.read)

}
