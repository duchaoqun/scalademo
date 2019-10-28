package cn.duchaoqun.Chapter18

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

import scala.io.Source

object Demo12 extends App {

  // 类或者特质可以定义一个在子类中被具体化的抽象类型（abstract type）
  trait Reader {
    type Contents

    def read(filename: String): Contents
  }

  // 在这里，类型 Contents 是抽象的，具体的子类需要指定这个类型：
  class StringReader extends Reader {
    override type Contents = String

    override def read(filename: String): String = {
      Source.fromFile(filename, "UTF-8").mkString
    }
  }

  // 同样的效果也可以通过类型参数来实现：
  trait ReaderNew[C] {
    def read(filename: String): C
  }

  class StringReaderNew extends ReaderNew[String] {
    override def read(filename: String): String = {
      Source.fromFile(filename, "UTF-8").mkString
    }
  }

  class ImageReader extends ReaderNew[BufferedImage]{
    override def read(filename: String): BufferedImage = {
      ImageIO.read(new File(filename))
    }
  }

  // 使用哪种方式更好呢？
  // 如果类型是在类被实例化时给出，则使用类型参数
  // 如果类型是在子类中给出，则使用抽象类型。

  // 在构建子类的时候给出类型参数并没有什么不好，但是当有多个类型依赖时，抽象类型用起来更方便，你可以避免使用一长串的类型参数。

  // 抽象类型还能够描述类型间那些微妙的相互依赖。
  // 抽象类型可以有类型界定。

}
