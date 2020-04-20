package cn.duchaoqun.Demo

import com.typesafe.config.{Config, ConfigFactory}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

/**
  * Slick
  * http://slick.lightbend.com/doc/3.3.2/
  * http://slick.lightbend.com/doc/3.3.2/api/index.html#package
  */
object Demo003 extends App {
  val config: Config = ConfigFactory.parseURL(getClass.getResource("/application.properties"))
  val db = Database.forConfig("db", config.getConfig("db.pg"))

  println(db.getClass)
}
