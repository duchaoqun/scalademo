package cn.duchaoqun.DemoJasperReport

import java.util

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRCsvExporter
import net.sf.jasperreports.engine.xml.JRXmlLoader
import net.sf.jasperreports.engine.{JasperCompileManager, JasperExportManager, JasperFillManager}

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object D_02 extends App {

  // 数据源：一个 List 对象，里面存放一个 Map 结构，用来存放字段值和，列表值。
  // 创建填充需要使用的Map对象，这里需要是 Java 对象。
  val param = new util.HashMap[String, Object]()

  // 添加 Field 键值对
  param.put("Column_1", "产品名称")
  param.put("Column_2", "笔均")
  param.put("Column_3", "全辖平均逾期率")
  param.put("Column_4", "全辖平均不良率")
  param.put("Column_5", "近三个月")
  param.put("Column_5_1", "笔均")
  param.put("Column_5_2", "全辖平均逾期率")
  param.put("Column_5_3", "全辖平均不良率")
  param.put("Column_6", "近六个月")
  param.put("Column_6_1", "笔均")
  param.put("Column_6_2", "全辖平均逾期率")
  param.put("Column_6_3", "全辖平均不良率")
  param.put("Column_7", "系统平均欺诈通过率")
  param.put("Column_8", "系统平均征信通过率")

  // 添加 DataSet1 数据表，注意都需要转换成 Java 的对象.
  val recorder1 = Map(
    "Field_1" -> "汽车分期",
    "Field_2" -> "4532",
    "Field_3" -> "10%",
    "Field_4" -> "12%",
    "Field_5" -> "433",
    "Field_6" -> "8%",
    "Field_7" -> "9%",
    "Field_8" -> "2345"
  ).asJava

  val recorder2 = Map(
    "Field_1" -> "车位分期",
    "Field_2" -> "4532",
    "Field_3" -> "10%",
    "Field_4" -> "12%",
    "Field_5" -> "433",
    "Field_6" -> "8%",
    "Field_7" -> "9%",
    "Field_8" -> "2345"
  ).asJava

  val recorder3 = Map(
    "Field_1" -> "房产抵押",
    "Field_2" -> "4532",
    "Field_3" -> "10%",
    "Field_4" -> "12%",
    "Field_5" -> "433",
    "Field_6" -> "8%",
    "Field_7" -> "9%",
    "Field_8" -> "2345"
  ).asJava

  // 将数据组装到 Map 对象中：
  val dataset1 = ArrayBuffer(recorder1,recorder2,recorder3).asJava
  val dataset2 = new util.ArrayList[util.HashMap[String, Object]]()

  param.put("tableData",new JRBeanCollectionDataSource(dataset1))

  // 准备 DataSource 使用的 List 对象：
  val fieldList = new util.ArrayList[util.HashMap[String,Object]]()
  fieldList.add(param)

  // 加载生成 JasperDesign 对象
  val jd = JRXmlLoader.load("C:/Users/Chris/JaspersoftWorkspace/MyReports/Blank_A4.jrxml")

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
