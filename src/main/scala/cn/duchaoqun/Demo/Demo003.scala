package cn.duchaoqun.Demo

import com.typesafe.config.{Config, ConfigFactory}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Slick
  * http://slick.lightbend.com/doc/3.3.2/
  * http://slick.lightbend.com/doc/3.3.2/api/index.html#package
  */
object Demo003 extends App {
  val config: Config = ConfigFactory.parseURL(getClass.getResource("/application.properties"))
  // 通过配置文件获取数据库连接
  val db = Database.forConfig("pg", config.getConfig("db"))

  println(db.getClass)

  val res6 = Await.result(db.run(sql"""select * from data_dictionary where e_value = 'Asia'""".as[(Long, String, Int)]), Duration.Inf)

  case class T01(id: Int, name: String)

  val aa = TableQuery[T01]

  DBIO.seq(aa.sche)

}
