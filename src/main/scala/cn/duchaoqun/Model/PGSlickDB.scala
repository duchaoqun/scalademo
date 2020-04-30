package cn.duchaoqun.Model

import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

/**
  * 使用 object 对象创建模板。
  */
object PGSlickDB {

  case class T1(c01: String)
  class T1Table(tag: Tag, tableName:String) extends Table[T1](tag, tableName) {
    def c01 = column[String]("c01")
    def * = c01 <> (T1 , T1.unapply)
  }
  // val t1 = TableQuery[T1]((tag:Tag)=>new T1(tag,"tablename"))


  case class T2(c01: String, c02: String)
  class T2Table(tag: Tag, tableName:String) extends Table[T2](tag, tableName) {
    def c01 = column[String]("c01", O.PrimaryKey)                     // 这个字段的属性是 VARCHAR(254) NOT NULL
    def c02 = column[String]("c02", O.Default("null"))  // 这个字段的属性是 VARCHAR(254) DEFAULT NULL NOT NULL
    def * = (c01, c02) <> (T2.tupled, T2.unapply)
  }
  // 库表实例: 通过这个对象创建数据库表, 执行增删改查等任务
  val t2 = TableQuery[T2Table]((tag:Tag)=>new T2Table(tag,"tablename"))


  case class T3(c01: String, c02: String, c03: String)
  class T3Table(tag: Tag, tableName:String) extends Table[T3](tag, tableName) {
    def c01 = column[String]("c01", O.PrimaryKey)
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def * = (c01, c02, c03) <> (T3.tupled, T3.unapply)
  }
  val t3 = TableQuery[T3Table]((tag:Tag)=>new T3Table(tag,"tablename"))


  case class T4(c01: String, c02: String, c03: String, c04: String)
  class T4Table(tag: Tag, tableName:String) extends Table[T4](tag, tableName) {
    def c01 = column[String]("c01", O.PrimaryKey)
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def * = (c01, c02, c03, c04) <> (T4.tupled, T4.unapply)
  }
  val t4 = TableQuery[T4Table]((tag:Tag)=>new T4Table(tag,"tablename"))


  case class T5(c01: String, c02: String, c03: String, c04: String, c05: String)
  class T5Table(tag: Tag, tableName:String) extends Table[T5](tag, tableName) {
    def c01 = column[String]("c01", O.PrimaryKey)
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def c05 = column[String]("c05")
    def * = (c01, c02, c03, c04, c05) <> (T5.tupled, T5.unapply)
  }
  val t5 = TableQuery[T5Table]((tag:Tag)=>new T5Table(tag,"tablename"))


  // 如果需要动态设置表的名称, 这里面我们可以将tablename定义为参数, 然后再需要的页面声明 TableQuery对象.
  case class T6(c00:String, c01: String, c02: String, c03: String, c04: String, c05: String, c06:String)
  class T6Table(tag: Tag, tableName:String) extends Table[T6](tag, tableName) {
    def c00 = column[String]("c00", O.PrimaryKey)
    def c01 = column[String]("c01")
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def c05 = column[String]("c05")
    def c06 = column[String]("c06")
    def * = (c00, c01, c02, c03, c04, c05, c06) <> (T6.tupled, T6.unapply)
  }
  // 在需要的页面上创建这个对象
  val t6 = TableQuery[T6Table]((tag:Tag)=>new T6Table(tag,"tablename"))


  // Definition of the SUPPLIERS table 表结构
  class UserInfo(tag: Tag) extends Table[(Long, String, Int)](tag, "USER_INFO") {
    def id = column[Long]("USER_ID", O.PrimaryKey, O.AutoInc) // This is the primary key column
    def name = column[String]("USER_NAME")
    def age = column[Int]("AGE")
    // Every table needs a * projection with the same type as the table's type parameter
    def * = (id, name, age)
  }
  val userInfo = TableQuery[UserInfo]


  class Email(tag: Tag) extends Table[(Long, Long, String)](tag, "EMAIL_INFO") {
    def emailID = column[Long]("EMAIL_ID", O.PrimaryKey)
    def userID = column[Long]("USER_ID")
    def email = column[String]("EMAIL")
    def * = (emailID, userID, email)
    // A reified foreign key relation that can be navigated to create a join
    def userinfo = foreignKey("USER_INFO_FK", userID, userInfo)(_.id)
  }
  val email = TableQuery[Email]


}
