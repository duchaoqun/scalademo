
// 项目基本信息
name := "ScalaDemo"
organization := "cn.duchaoqun"
version := "0.0.3-SNAPSHOT"
scalaVersion := "2.13.0"

// PG 数据库驱动
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.5"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.0-M7"

// 在使用Jasper的时候需要用到如下包：
// https://mvnrepository.com/artifact/com.lowagie/itext
libraryDependencies += "com.lowagie" % "itext" % "2.1.7"
// https://mvnrepository.com/artifact/net.sf.jasperreports/jasperreports
libraryDependencies += "net.sf.jasperreports" % "jasperreports" % "6.8.0"


// 加密
// https://mvnrepository.com/artifact/org.mindrot/jbcrypt
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"


// 网站爬虫相关的包
// https://mvnrepository.com/artifact/org.jsoup/jsoup
libraryDependencies += "org.jsoup" % "jsoup" % "1.12.1"
// https://mvnrepository.com/artifact/net.sourceforge.htmlunit/htmlunit
libraryDependencies += "net.sourceforge.htmlunit" % "htmlunit" % "2.36.0"


// SQLite Database
// https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.28.0"

// 引入一些外部包，在项目中创建一个lib目录，然后将这些包放到这里。
// unmanagedJars in Compile ++= Seq(
//   Attributed.blank[File](file(baseDirectory.value + "/lib/jcommon-1.0.23.jar")),
//   Attributed.blank[File](file(baseDirectory.value + "/lib/jfreechart-1.0.19.jar"))
// )


// 单元测试
// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12"

// 记录日志的相关包
// https://github.com/lightbend/scala-logging
//libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

// https://mvnrepository.com/artifact/com.typesafe.scala-logging/scala-logging
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"

// Spark 相关
// https://mvnrepository.com/artifact/org.apache.spark/spark-core
//libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib
//libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.0.2" % "runtime"