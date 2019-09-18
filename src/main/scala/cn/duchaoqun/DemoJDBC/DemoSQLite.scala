package cn.duchaoqun.DemoJDBC

import java.sql.DriverManager

object DemoSQLite extends App {
  Class.forName("org.sqlite.JDBC").newInstance()
  val con = DriverManager.getConnection("jdbc:sqlite::memory:")

  val  statement = con.createStatement
  // db路径
  val temp="C:/Users/ducha/Desktop/aoye.db"

  // 数据库起命名 tmpsqlite
  var attachsql = "ATTACH '"+temp+"' AS tmpsqlite"
  statement.executeUpdate(attachsql)

  //执行sql(该sql是查看当前db所有表)
  val citys = "select * from tmpsqlite.sqlite_master where type='table' order by name"
  val cityResult = statement.executeQuery(citys)

  //遍历结果集
  while(cityResult.next()){
    print(cityResult.getString("name"))
  }

  //关闭连接
  con.close()

}
