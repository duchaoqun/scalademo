package info.aoye.DemoJDBC

import java.sql.{Connection, DriverManager, ResultSet}

/**
  * 链接Postgres数据库获取数据。
  */
object DemoPostgres extends App {

  // The scene of Master/Slave.
  val strConn1: String = "jdbc:postgresql://172.16.1.83:5432,172.16.1.228:5432/duchaoqun?user=postgres&password=123456"

  // The scene of Master/Salve/Salve/Patroni/Etcd. The cluster has three nodes.
  val strConn2: String = "jdbc:postgresql://192.168.1.120:5432,192.168.1.121:5432,192.168.1.122:5432/test1?targetServerType=master&user=postgres&password=123456"
  val conn = DriverManager.getConnection(strConn2)

  // 基本的查询方法
  def selectObj(sql: String, conn: Connection): ResultSet = {
    val prep = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
    val rs = prep.executeQuery(sql)
    rs
  }
//  val result1 = selectObj("select count(*) as aaa from tt_1", conn)
//  while (result1.next()) {
//    println(result1.getString("aaa"))
//  }
//
//  val result2 = selectObj("select count(*) as bbb from tt_1", conn)
//  while (result1.next()) {
//    println(result1.getString("bbb"))
//  }


  // 基本的插入语句
  val sql = "insert into table1(id, name) values(?,?)"
  val ps = conn.prepareStatement(sql)
  ps.setInt(1, 1)
  ps.setString(2, "Scala")
  ps.executeUpdate()


  for ( x <- 1 to 100 ){
    val ps = conn.prepareStatement(sql)
    ps.setInt(1, x)
    ps.setString(2, "Scala")
    ps.executeUpdate()
    Thread.sleep(1000)
  }

  // Thread.sleep(100000)
  // 如果这个Thread alway exist，连接就会存在，You can close it by yourself.
  conn.close()
}
