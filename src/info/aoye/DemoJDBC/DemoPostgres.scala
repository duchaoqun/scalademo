package info.aoye.DemoJDBC

import java.sql.{Connection, DriverManager, ResultSet}

/**
  * 链接Postgres数据库获取数据。
  */
object DemoPostgres extends App {
  val strConn: String = "jdbc:postgresql://172.16.1.83:5432/lms_20190522?user=postgres&password=111111"
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

  val result2 = selectObj("select count(*) as bbb from account", conn)
  while (result1.next()) {
    println(result1.getString("bbb"))
  }

  Thread.sleep(100000)
  //conn.close()
  // 1. Thread 存在的时候，连接就会存在

}
