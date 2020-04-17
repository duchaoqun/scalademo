package cn.duchaoqun.Test

import java.io.File

object Demo003 extends App {

  // 返回 runtime 对象的类型
  println(this.getClass)    // class cn.duchaoqun.Demo.Demo003$
  println(getClass)         // class cn.duchaoqun.Demo.Demo003$
  println(getClass.getResource("/application.properties").getClass)  // class java.net.URL

  // getResource 与 getResourceAsStream 在路径选择上是一致的
  println(getClass.getResource(""))            // 默认是以此类所在包下取资源
  println(getClass.getResource("/"))           // 从 ClassPath 根下取资源
  println(ClassLoader.getSystemResource(""))   // 从 ClassPath 根下取资源
  println(ClassLoader.getSystemResource("/"))  // null


  // 使用Config对象
  import com.typesafe.config.{Config, ConfigFactory}

  // 创建一个空的Config对象
  val configFactory: Config = ConfigFactory.empty()

  // 创建一个Config对象，从文件读取
  val configFactory1: Config = ConfigFactory.parseFile(new File("/opt/etc/test.conf"))

//  val configFactory2: Config = ConfigFactory.parseFile(Source.from)

}
