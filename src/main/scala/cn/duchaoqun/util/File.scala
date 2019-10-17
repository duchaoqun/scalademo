package cn.duchaoqun.util

import java.io.File

import scala.util.Try

object File {

  /**
    * 判断一个文件是否存在，如果不存在就创建这个文件。
    *
    * @param file 文件对象
    */
  def createFileIfNotExist(file: File): Unit = {
    if (file.exists()) {
      println("File is exist!")
    } else {
      // Remember to create the parent Dirs !!
      Try(file.getParentFile.mkdirs())
      Try(file.createNewFile())
    }
  }

  def createFileIfNotExist1(file: File): Unit = {
    try {
      file.createNewFile()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }


  /**
    * 获取目录下面所有文件的File对象
    *
    * @param path 目录File对象
    * @return
    */
  def getFiles(path: String): Array[File] = {
    new File(path).listFiles
  }

  // File file = new File("C:\\Users\\Chris\\Desktop\\1.txt")
  // InputStream inputStream = new FileInputStream(file)
}
