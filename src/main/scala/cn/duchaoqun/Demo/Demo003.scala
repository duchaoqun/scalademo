package cn.duchaoqun.Demo

import com.typesafe.config.{Config, ConfigFactory}
import slick.jdbc.PostgresProfile.api._
import slick.lifted.{TableQuery, Tag}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import com.typesafe.scalalogging.LazyLogging

import scala.util.Success
import scala.util.Failure
import scala.language.postfixOps

/**
  * Slick
  * http://slick.lightbend.com/doc/3.3.2/
  * http://slick.lightbend.com/doc/3.3.2/api/index.html#package
  */
object Demo003 extends App with LazyLogging{

  // 获取配置文件信息
  val config: Config = ConfigFactory.parseURL(getClass.getResource("/application.properties"))
  // 通过配置文件获取数据库连接
  val db = Database.forConfig("pg", config.getConfig("db"))
  // slick.jdbc.JdbcBackend$DatabaseDef
  logger.info(db.getClass.toString)


  // 案例1： 表的结构和名称是固定的，没有其他表与该表结构相同，通常情况。
  case class UserInfo(id: Long, name: String, age: Int)
  // 模型类，直接指定表的名称。
  class UserInfoTable(tag: Tag) extends Table[UserInfo](tag, "user_info") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def age = column[Int]("age")
    def * = (id, name, age) <> (UserInfo.tupled, UserInfo.unapply)
  }
  // 创建 TableQuery 对象
  // def slick_table_0 = TableQuery[UserInfoTable]
  // 通过 TableQuery class 创建表
  // Await.result(db.run(slick_table.schema.create), Duration.Inf)
  // 通过 TableQuery class 查询表
  // val res0 = Await.result(db.run(slick_table.filter(_.age > 25).result), Duration.Inf)


  // 案例2：表名称不固定，但是表结构是固定的，适用于临时表。
  case class T1(c01: String)
  class T1Table(tag: Tag, tableName: String) extends Table[T1](tag, tableName) {
    def c01 = column[String]("c01")
    def * = c01 <> (T1, T1.unapply)
  }
  // 创建 TableQuery 对象，这里可以指定表的名称。
   def t1_table = TableQuery[T1Table]((tag: Tag) => new T1Table(tag, "tablename"))
  // Await.result(db.run(t1_table.schema.create),Duration.Inf)
  logger.info("Query is OK!")
  // 注意：slick的数据库操作是异步的，返回的是Future对象


  // Query Action: query all
  val query_action = t1_table.result

  println(t1_table.result)  // slick.jdbc.JdbcActionComponent$QueryActionExtensionMethodsImpl$$anon$2@40317ba2

  // slick run returns a future, we can use andThen to get async response and use Await.result to get result
  val res0 = db.run(query_action) andThen
  {
    case Success(_) => println("Query Success!")
    case Failure(e) => println("query failed ", e.getMessage)
  }

  db.run(t1_table.result) map {
    result => println(result)
  }

  // block thread to get select result
  // Await.result(res0, 10 seconds)  // specify the timeout



  // query by condition.
  val res1 = Await.result(db.run(sql"""select * from data_dictionary where e_value = 'Asia'""".as[(Long, String, Int)]), Duration.Inf)

  // add only 1 record.
  val t1_1 = T1(c01 = "Scala")
  // return the insert number: 1, so no need to return.
  val res2 = Await.result(db.run(t1_table += t1_1), Duration.Inf)
  println(res2)


  // add batch record.
  val t1_2 = T1(c01 = "Java")
  val t1_3 = T1(c01 = "Python")
  val t1Seq = Seq[T1](t1_2,t1_3)
  val res3 = Await.result(db.run(t1_table ++= t1Seq), Duration.Inf) // Some(2)
  println(res3)


  // delete, 这里是三个等号
  val res4 = Await.result(db.run(t1_table.filter(_.c01 === "asdf").delete), Duration.Inf)
  println(res4)

  //  def createTableIfNotExist(tableName: String, tableColumnNumber: Int): Boolean ={
  //    val setup = DBIO.seq(
  //      tableColumnNumber match {
  //        case 1 => new TableQuery[T1]((tag: Tag) => new T1(tag, tableName)).schema.create
  //        case 2 => new TableQuery[T2]((tag: Tag) => new T2(tag, tableName)).schema.create
  //        case 3 => new TableQuery[T3]((tag: Tag) => new T3(tag, tableName)).schema.create
  //        case 4 => new TableQuery[T4]((tag: Tag) => new T4(tag, tableName)).schema.create
  //        case 5 => new TableQuery[T5]((tag: Tag) => new T5(tag, tableName)).schema.create
  //        case 6 => new TableQuery[T6]((tag: Tag) => new T6(tag, tableName)).schema.create
  //      }
  //    )
  //    slick.jdbc.meta.MTable
  //    Await.result(db.run(setup),Duration.Inf)
  //    false
  //  }
  //
  //  createTableIfNotExist("asdf", 2)
//
//  val new_user = UserInfo(3L, "tashaxing", 23)
//  val res4 = Await.result(db.run(slick_table.filter(_.id === new_user.id).update(new_user)), Duration.Inf) // return effected row numbers

//  // return main column after insert
//  val user = UserInfo(0, "ethan", 21)
//  val save_sql = (slick_table returning slick_table.map(_.id)) += user
//  val user_id = Await.result(db.run(save_sql), Duration.Inf) // return created id
//
//  // ---- use sql
//
//  // query sql
//  val res6 = Await.result(db.run(sql"""select * from scala_model where name = 'mary'""".as[(Long, String, Int)]), Duration.Inf)
//
//  // insert sql
//  val id = 10L
//  val name = "wilson"
//  val age = 29
//  val res7 = Await.result(db.run(sqlu"""insert into scala_model values($id, $name, $age)"""), Duration.Inf) // use variable outside
//  //    val res7 = Await.result(db.run(sqlu"""insert into scala_model values(10, 'bob', 28)"""), Duration.Inf) // use variable in string
//
//  // update sql
//  val res8 = Await.result(db.run(sqlu"""update scala_model set name='lily' where id=4"""), Duration.Inf)
//
//  // delete sql
//  val res9 = Await.result(db.run(sqlu"""delete from scala_model where name='mary'"""), Duration.Inf)
}
