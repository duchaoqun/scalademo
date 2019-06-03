package info.aoye.Chapter9

import java.io.File

/**
  * 9.9 进程控制【A2】
  * 按照传统习惯，程序员使用Shell脚本来执行日常处理任务，比如把文件从一处移动到另外一处。
  * Scala的设计目的之一就是能在简单的脚本化任务和大型程序之间保持良好的伸缩性。
  * scala.sys.process包提供了用于与shell程序交互的工具，你可以用scala编写shell脚本。
  */
object Demo9_9 extends App {
  import sys.process._

  // 执行系统的ls -lart . 命令，执行结果返回到标准输出
  "ls -lart ." !
  /*
  sys.process包包含了一个从字符串到 ProcessBuilder对象的隐式转换。
  ！操作符执行的就是这个ProcessBuilder对象。
  ！操作符返回的结果就是程序的执行结果，执行成功返回0， 执行失败返回错误信息（非0值）
   */

  // 如果使用两个叹号，结果会以字符串的形式返回
  val res = "ls -lart ." !!

  // 也可以使用 #| 将前一个命令的输出传递到后一个命令，就是管道符
  "ls -lart ." #| "grep src" !

  // 把输出重定向到文件
  "ls -lart ." #> new File("output.txt")
  // 把输出追加到文件
  "ls -lart ." #>> new File("output.txt")

  // 如果你需要在不同目录运行进程，或者使用不同的环境变量，用Process对象的apply方法来构造ProcessBuilder，给出命令和目录
  // 以及一串键值对来设置环境变量：

  val cmd = ""
  val dirName = ""
  val p = Process(cmd,new File(dirName),("LANG","en_US"))
  // 然后用！操作符执行它
  "echo 43" #| p !
}
