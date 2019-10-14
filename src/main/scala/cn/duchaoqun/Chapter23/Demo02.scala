package cn.duchaoqun.Chapter23

import scala.sys.SystemProperties
import scala.util.Properties

object Demo02 extends App {
  // 直接获取系统参数的工具类
  // 获取当前用户目录，绝对路径
  println(Properties.userDir)
  // 获取系统名称
  println(Properties.osName)
  // 获取用户的主目录
  println(Properties.userHome)
}
