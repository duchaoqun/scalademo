package info.aoye.DemoJasperReport

import java.util
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.xml.JRXmlLoader
import net.sf.jasperreports.engine.{JasperCompileManager, JasperExportManager, JasperFillManager}
import scala.collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

object D_01 extends App {

  // 创建填充需要使用的Map对象，这里需要是 Java 对象。
  val param = new util.HashMap[String, Object]()

  // 添加 Field 键值对
  param.put("Version", "11")
  param.put("Name", "FSS")

  // 添加 DataSet1 数据表，注意都需要转换成 Java 的对象.
  val recorder1 = Map("name" -> "zhangsan", "age" -> "12").asJava
  val recorder2 = Map("name" -> "lisi", "age" -> "21").asJava
  val dataset1 = ArrayBuffer(recorder1,recorder2).asJava
  param.put("dataset1",new JRBeanCollectionDataSource(dataset1))

  // 准备 DataSource 对象：
  val fieldList = new util.ArrayList[util.HashMap[String,Object]]()
  fieldList.add(param)

  // 加载生成 JasperDesign 对象
  val jd = JRXmlLoader.load("C:/Users/ducha/JaspersoftWorkspace/MyReports/Blank_A4.jrxml")

  // 编译生成 jasper 对象
  val jreport = JasperCompileManager.compileReport(jd)

  // 第一个参数是 Jasper 对象。
  // 第二个参数是 Map 对象，用来传递参数值。
  // 第三个参数是 DataSource 对象，用来填充表格。
  val jasperPrint = JasperFillManager.fillReport(jreport, param, new JRBeanCollectionDataSource(fieldList))

  //导出PDF文件
  JasperExportManager exportReportToPdfFile(jasperPrint, "C:/Users/ducha/Desktop/Blank_A4.pdf")

  //导入HTML文件
  JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:/Users/ducha/Desktop/Blank_A4.html")
}
