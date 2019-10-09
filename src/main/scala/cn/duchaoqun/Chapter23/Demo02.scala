package cn.duchaoqun.Chapter23

import scala.sys.SystemProperties

object Demo02 extends App {
  // 退出当前程序.
  System.exit(1)

  System.lineSeparator()  // 根据操作系统获取换行符

  // 获取操作系统参数
  val pp = new SystemProperties  // 创建系统参数对象
  println(pp.get("user.dir"))    // 获取系统参数,内容是一个Map对象,get的结果是Some对象

  // 使用系统代理
  System.setProperty("http.maxRedirects", "50")
  System.getProperties.setProperty("proxySet", "true")
  val ip = "127.0.0.1"
  System.getProperties.setProperty("http.proxyHost", ip)
  System.getProperties.setProperty("http.proxyPort", "1080")

}
