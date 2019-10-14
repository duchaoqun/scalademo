package cn.duchaoqun.Chapter25

import java.net.URL
import java.io.File
// 首先要导入下面这个包
import sys.process._
// todo , 需要详细了解一下这个特性
import scala.language.postfixOps


/**
  * 执行系统命令
  * 1. 在执行系统命令的代码行后面需要空一个空行，不知道为什么
  * 2. 工作原理: Scala是基于JVM进程的, Scala程序运行的时候会运行在JVM进程中, 而JVM是OS的一个普通进程, 通过JVM可以直接和
  *    OS进行交互, 而OS中有例如启动进程等功能, 所以!!!
  */
object Demo01 extends App {
  //执行系统命令，等待该命令执行完毕后返回结果，然后在继续执行下面的代码
  //注意：可以在sh里面加时间控制
  //http://www.scala-lang.org/api/2.12.2/scala/sys/process/index.html

  //执行外部命令
  val int1 = "/home/aoye/Documents/bash/test.sh".!
  println(int1)

  //直接打印命令结果
  val int2 = "ls".!
  println(int2) //命令成功执行返回0，不等于0说明命令执行出错

  //将命令执行结果保存到变量中
  val str1 = "ls".!!
  println(str1.getClass) //java.lang.String
  println(str1)

  //逻辑操作管道  #|   与操作 #&&  或操作#||
  //"find src -name *.scala -exec grep null {} ;" #| "xargs test -z" #&& "echo null-free" #|| "echo null detected" !


  //重定向#< 和 #>
  //scala的重定向不仅可以从定向普通的文件，还可以把网络上的文件进行重定向到本地:
  //注意：url和file均需进行封装 java.net.URL 否则会出现报错
  //将网络地址内容重定向到本地
  new URL("http://aoye.info") #> new java.io.File("/tmp/a.html") !

  //命令结果重定向到文件
  "ls -l" #> new File("/tmp/ls.txt") !!

  //将文件内容重定向给指定命令
  "cat" #< new File("/tmp/ls.txt") !

  //将文件重定向到新文件
  new File("/tmp/ls.txt") #> new File("/tmp/lsnew.txt") !!


  //追加操作  #>>  #<<
  //a #>> file or file #<<  与重定向类似


  //    与cat一起使用
  //    val spde = new URL("http://technically.us/spde/About")
  //    val dispatch = new URL("http://databinder.net/dispatch/About")
  //    val build = new File("project/build.properties")
  //    cat(spde, dispatch, build) #| "grep -i scala" !

  //获取操作系统环境变量
  //println(System.getenv("PATH"))




  // 执行外部命令,返回程序的执行过程
  val int4 = "/home/aoye/Documents/bash/test.sh".!!
  println(int4)

  //command argument error!
  //这里后面的时间参数传入到命令里面会被解析成两部分!!!   "2018-04-16  和 12:12:12" 中间被空格截断了.
  val int5 = """/home/aoye/Documents/bash/test.sh -- "2018-04-16 12:12:12" """.!!
  val int6 = """/home/aoye/Documents/bash/test.sh -- "2018-04-16 12:12:12" """.!
  println(int5)
  //解决办法:使用Seq来操作
  //使用seq的方式会自动在参数直接添加空格,不需要手动在字符串两边拼空格.
  val int7 = Seq("/home/aoye/Documents/bash/test.sh","--","2018-04-16 12:12:12").!!
  print(int7)

  val seq1:Seq[String]= Seq("/home/aoye/Documents/bash/test.sh","--","2018-04-16 12:12:12")

  println(seq1!)
}
