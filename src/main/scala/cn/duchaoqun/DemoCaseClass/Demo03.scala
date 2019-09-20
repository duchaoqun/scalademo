package cn.duchaoqun.DemoCaseClass

// 自定义一个 Exception 类型。
case class Demo03_Exception(msg: String) extends Exception{
  override def getMessage: String = {
    msg
  }
}

object Demo03 extends App {
  try {
    throw Demo03_Exception("Error")
  } catch {
    case ex: Exception => println(ex.getMessage)
  } finally {
    println("Over")
  }
}
