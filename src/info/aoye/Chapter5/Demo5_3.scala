package info.aoye.Chapter5

/**
  * 5.3 只有getter的属性
  */
object Demo5_3 extends App {

}

class Message {
  // 有时候你需要一个只读属性，有getter但是没有setter，如果属性的值在对象创建完成之后就不会再改变，则可以使用val关键字。
  val timeStamp = new java.util.Date
}
