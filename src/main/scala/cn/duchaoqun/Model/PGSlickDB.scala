package cn.duchaoqun.Model

import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

class PGSlickDB {
  // 表字段对应的模板
  case class T3Model(c01: String, c02: String, c03: String)
  // 表结构: 定义字段类型, * 代表结果集字段
  class T3(tag: Tag) extends Table[T3Model](tag, "T3") {
    def c01 = column[String]("c01", O.PrimaryKey)       // 这个字段的属性是 VARCHAR(254) NOT NULL
    def c02 = column[String]("c02", O.Default("null"))  // 这个字段的属性是 VARCHAR(254) DEFAULT NULL NOT NULL
    def c03 = column[String]("c03")
    def * = (c01, c02, c03) <> (T3Model.tupled, T3Model.unapply)
  }
  // 库表实例: 通过这个对象创建数据库表, 执行增删改查等任务
  val t3 = TableQuery[T3]


  case class T4Model(c01: String, c02: String, c03: String, c04: String)
  class T4(tag: Tag) extends Table[T4Model](tag, "T4") {
    def c01 = column[String]("c01", O.PrimaryKey)
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def * = (c01, c02, c03, c04) <> (T4Model.tupled, T4Model.unapply)
  }
  val t4 = TableQuery[T4]


  case class T5Model(c01: String, c02: String, c03: String, c04: String,c05: String)
  class T5(tag: Tag) extends Table[T5Model](tag, "T5") {
    def c01 = column[String]("c01", O.PrimaryKey)
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def c05 = column[String]("c05", O.Default("null"))  // 这个字段的属性是 VARCHAR(254) NOT NULL
    def * = (c01, c02, c03, c04, c05) <> (T5Model.tupled, T5Model.unapply)
  }
  val t5 = TableQuery[T5]

  // 如果需要动态设置表的名称, 这里面我们可以将tablename定义为参数, 然后再需要的页面声明 TableQuery对象.
  case class T6Model(c00:String, c01: String, c02: String, c03: String, c04: String, c05: String, c06:String)
  class T6(tag: Tag, tableName:String) extends Table[T6Model](tag, tableName) {
    def c00 = column[String]("c00", O.PrimaryKey)
    def c01 = column[String]("c01")
    def c02 = column[String]("c02")
    def c03 = column[String]("c03")
    def c04 = column[String]("c04")
    def c05 = column[String]("c05")
    def c06 = column[String]("c06")
    def * = (c00, c01, c02, c03, c04, c05, c06) <> (T6Model.tupled, T6Model.unapply)
  }
  // 在需要的页面上创建这个对象
  val t6 = TableQuery[T6]((tag:Tag)=>new T6(tag,"tablename"))


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
