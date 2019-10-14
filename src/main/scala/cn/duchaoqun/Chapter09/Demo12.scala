package cn.duchaoqun.Chapter09

import java.io.{BufferedWriter, File, FileWriter}

import scala.util.Try

object Demo12 extends App {
  // Demo1 判断一个文件是否存在, 如果不存在就创建这个文件.
  val file1 = new File("""C:\Users\Administrator\Documents\WebData\a.txt""")
  if (file1.exists()) {
    println("File is exist!")
  } else {
    // Remember to create the parent Dirs !!
    Try(file1.getParentFile.mkdirs())
    Try(file1.createNewFile())
  }

  /*
   *  将要写入文件的内容先写入缓冲区, 然后再统一写入文件, IO操作比较少
   */
  val fileWriter = new FileWriter(file1,true)
  val bufferedWriter = new BufferedWriter(fileWriter)
  bufferedWriter.write("第s行字符" + System.getProperty("line.separator"))  // 写入缓冲区
  bufferedWriter.write("第s行字符" + System.getProperty("line.separator"))  // 写入缓冲区
  bufferedWriter.flush()  // 缓冲区写入文件.
  bufferedWriter.close()
  fileWriter.close()
}
