package cn.duchaoqun.Chapter09

import scala.collection.mutable.ArrayBuffer

/**
  * 9.8 序列化
  * 在Java中，我们用序列化来将对象传输到其他虚拟机，或者临时存储。
  */
object Demo9_8 extends App {
  val c1 = new Demo9_8_1

  // 使用常规的方式进行序列化和反序列化
  import java.io._
  val out = new ObjectOutputStream(new FileOutputStream("Demo9_8_1.obj"))
  out.writeObject(c1)
  out.close()

  val in = new ObjectInputStream(new FileInputStream("Demo9_8_1.obj"))
  val savedC1 = in.readObject().asInstanceOf[Demo9_8_1]
}

// 如果你能接受默认的ID，也可以省略注解
@SerialVersionUID(42L)
class Demo9_8_1 extends Serializable{
  // Scala中的集合类都是可序列化的，因此你可以把他们用作你的可序列化的成员
  private val some=new ArrayBuffer[Demo9_8_1]
}