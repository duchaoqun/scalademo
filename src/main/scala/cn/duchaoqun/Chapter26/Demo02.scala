package cn.duchaoqun.Chapter26

import com.typesafe.config.{Config, ConfigFactory}

object Demo02 extends App {
  // 案例：使用默认配置，如果用户提供配置文件中没有配置一些内容，那么将默认配置添加上去
  val confUser: Config = ConfigFactory.parseString(
    """
      |mysql.user="root"
      |mysql.password="123456"
    """.stripMargin)

  val confDefault: Config = ConfigFactory.parseString(
    """
      |mysql.user="root"
      |mysql.password="123456"
      |mysql.port="3306"
    """.stripMargin)
  val config3 = confUser.withFallback(confDefault)
}
