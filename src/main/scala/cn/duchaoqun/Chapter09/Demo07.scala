package cn.duchaoqun.Chapter09

import java.io.File

import scala.collection.mutable

object Demo07 extends App {
  // 获取一个目录中的文件
  val getFiles = (path: File) => path.listFiles()

  // 获取一个目录中的二级目录
  val getDirectories = (path: File) => path.listFiles.filter(_.isDirectory)

  // 获取一个目录中的所有所有文件，递归所有子目录


  def subDirs(dir: File): mutable.ArraySeq[File] ={
    val children = dir.listFiles.filter(_.isDirectory)
    children.toIterable ++ children.toIterable.flatMap(subDirs)
  }


  val files = subDirs(new File("D:\\Test"))

  files.foreach(x => println(x.getName))

  getDirectories
}
