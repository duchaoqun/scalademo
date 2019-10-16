package cn.duchaoqun.Chapter09

import scala.collection.mutable.ArrayBuffer

object Demo08 extends App {

  // Serializable 特质在 Scala 包中，默认已经被引入。
  // 如果你能接受默认的 ID，也可以省略注解
  @SerialVersionUID(42L)
  class Test extends Serializable {
    // Scala 中的集合类都是可序列化的，因此你可以把他们用作你的可序列化的成员
    private val some = new ArrayBuffer[Test]
  }

  val c1 = new Test

  // 使用常规的方式进行序列化和反序列化
  import java.io._

  val out = new ObjectOutputStream(new FileOutputStream("Demo9_8_1.obj"))
  out.writeObject(c1)
  out.close()

  val in = new ObjectInputStream(new FileInputStream("Demo9_8_1.obj"))
  val savedC1 = in.readObject().asInstanceOf[Test]
}

