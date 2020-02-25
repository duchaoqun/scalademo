package cn.duchaoqun.DemoJasperReport

import java.util

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRCsvExporter
import net.sf.jasperreports.engine.xml.JRXmlLoader
import net.sf.jasperreports.engine.{JasperCompileManager, JasperExportManager, JasperFillManager}

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

/**
  * 合同套打功能Demo
  */
object D_03 extends App {

  // 数据源：一个 List 对象，里面存放一个 Map 结构，用来存放字段值和列表值。
  // 创建填充需要使用的Map对象，这里需要是 Java 对象。
  val param = new util.HashMap[String, Object]()

  // 添加 Field 键值对，这里仅使用单个字段即可。
  param.put("ID", "220323199002252222")
  param.put("Name", "220323199002252222")

  // 准备 DataSource 使用的 List 对象：
  val fieldList = new util.ArrayList[util.HashMap[String,Object]]()
  fieldList.add(param)

  // 加载生成 JasperDesign 对象
  val jd = JRXmlLoader.load("C:/Users/Chris/JaspersoftWorkspace/MyReports/Blank_A4_2.jrxml")

  // 编译生成 jasper 对象
  val jreport = JasperCompileManager.compileReport(jd)

  // 第一个参数是 Jasper 对象。
  // 第二个参数是 Map 对象，用来传递参数值。
  // 第三个参数是 DataSource 对象，用来填充表格。
  val jasperPrint = JasperFillManager.fillReport(jreport, param, new JRBeanCollectionDataSource(fieldList))

  //导出PDF文件
  JasperExportManager exportReportToPdfFile(jasperPrint, "C:/Users/Chris/Desktop/Blank_A4.pdf")

  //导入HTML文件
  JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:/Users/Chris/Desktop/Blank_A4.html")

  // todo
  val exp = new JRCsvExporter()
}
