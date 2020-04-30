package cn.duchaoqun.Model

// 需要引入的包
import slick.jdbc.PostgresProfile.api._
import slick.lifted.Tag

// Definition of the "article" table
class Article(tag: Tag) extends Table[(Long, String, String)](tag, _tableName = "article") {
  // This is the primary key column
  // AutoInc 类型的字段在新增的时候可以传入0，这并不影响记录的插入。
  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def title: Rep[String] = column[String]("title", O.Length(254))

  def content: Rep[String] = column[String]("content", O.Length(10240))

  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, title, content)
}