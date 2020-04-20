package cn.duchaoqun.Chapter26

import java.io.File

import com.typesafe.config.ConfigValueFactory

object Demo01 extends App {
  // 返回 runtime 对象的类型
  println(this.getClass)    // class cn.duchaoqun.Demo.Demo003$
  println(getClass)         // class cn.duchaoqun.Demo.Demo003$
  println(getClass.getResource("/application.properties").getClass)  // class java.net.URL

  // getResource 与 getResourceAsStream 在路径选择上是一致的
  println(getClass.getResource(""))            // 默认是以此类所在包下取资源
  println(getClass.getResource("/"))           // 从 ClassPath 根下取资源
  println(ClassLoader.getSystemResource(""))   // 从 ClassPath 根下取资源
  println(ClassLoader.getSystemResource("/"))  // null

  // 使用 Config 对象
  import com.typesafe.config.{Config, ConfigFactory}

  // 创建一个空的 Config 对象
  val config0: Config = ConfigFactory.empty()

  // 创建一个Config对象，从文件读取
  val config1: Config = ConfigFactory.parseFile(new File("/opt/etc/test.conf"))

  // 创建一个 Config 对象，从 URL 对象获取
  val config2: Config = ConfigFactory.parseURL(getClass.getResource("/application.properties"))

  // 从字符串来读取 Config 对象
  val config3: Config = ConfigFactory.parseString(
    """
      |input {
      |  hive {
      |    table = "e_base_info"
      |    columns = ["pripid","entname"]
      |  }
      |}
    """.stripMargin)

  // 从字符串来读取 Config 对象
  val config4: Config = ConfigFactory.parseString(
    """
      | mysql.user = root
      | mysql.password = 123456
      | mysql.port = 3306
    """.stripMargin)


  // 判断是否存在这个节点，有就返回true
  config2.hasPath("input")

  // 检查配置
  config2.checkValid(ConfigFactory.defaultReference(), "simple-lib")

  // 检查是否为空
  if (config2.isEmpty) println("config file is null!")

  // 取出所有内容
  val config5 = config2.root()

  // 取出Config对象的分支内容
  val config6 = config2.getConfig("input.hive").root()

  // 获取配置文件内容：直接输入路径即可
  val configValue1 = config2.getString("input.hive.table")

  // 案例：向配置文件里面插入值
  // 在一个Config对象中添加内容
  // 向一个Config对象里面添加值,这里会自动根据句号分割!!
  val config7: Config = ConfigFactory.empty()
  val config8: Config = config3
    .withValue("spark.streaming.batchDuration", ConfigValueFactory.fromAnyRef("5"))
    .withValue("dish.name", ConfigValueFactory.fromAnyRef("SomeCompany"))
    .withValue("dish.estimatedCost", ConfigValueFactory.fromAnyRef(10))
}
