package info.aoye.DemoJDBC

import java.sql.{Connection, DriverManager, ResultSet}

object DemoMySQL extends App {
  val strConn: String = "jdbc:mysql://172.16.1.83:5432/lms_20190522?user=postgres&password=111111"
  val conn = DriverManager.getConnection(strConn)
  def selectObj(sql: String, conn: Connection): ResultSet = {
    val prep = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val rs = prep.executeQuery(sql)
    rs
  }

  val result1 = selectObj("select count(*) as aaa from account",conn)
  while (result1.next()) {
    println(result1.getString("aaa"))
  }
  conn.close()
}
