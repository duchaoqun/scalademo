package cn.duchaoqun.util

import java.sql.{Connection, DriverManager}

/**
  * JDBC 相关的工具类
  */
object JDBC {
  def getPGConn: Connection =  {
    val strConn: String = "jdbc:postgresql://127.0.0.1:5432/aoye?user=Chris&password="
    val conn = DriverManager.getConnection(strConn)
    conn
  }
}
