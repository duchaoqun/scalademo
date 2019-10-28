package cn.duchaoqun.Chapter18

import java.awt.{Point, Rectangle, Shape}
import java.awt.geom.Area

import scala.collection.mutable.ArrayBuffer

object Demo06 extends App {

  // 复合类型的定义形式如下：
  // T1 with T2 with T3 ...
  // 其中 T1 、T2、T3 等是类型。
  // 想要成为复合类型的实例，某个值必须满足每一个类型的要求才行。因此这样的类型也被称为交集类型。

  // 你可以用复合类型来操纵那些必须提供多个特质的值

  val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]()

  // 你可以用 for( s <- image) graphics.draw(s) 来绘制这图像
  // 你可以序列化这个 image 对象，因为你知道所有的元素都是可以被序列化的。

  // 当然了，你只能添加那些即是形状（Shape）也是可被序列化的对象:

  val rect = new Rectangle(5, 10, 20,30)
  image += rect // Rectangle 是可以被序列化的。
  // image += new Area(rect) // 错误 --- Area 是 Shape 但不是能序列化的。

  // 这段代码意味着 ImageShape 扩展自交集类型Shape with Serializable
  trait ImageShape extends Shape with Serializable

  // 你可以把结构类型的声明添加到简单类型或复合类型
  trait ImageShape1 extends Shape with Serializable {def contains(p: Point): Boolean}
  // 该实例的类型必须是 Shape 和 Serializable 的子类型，且必须有一个带 Point 的 contains 方法。

  // 结构类型
  // { def append(str: String): Any }  等于 AnyRef { def append(str: String): Any }

  // 复合类型
  // Shape with Serializable 等于 Shape with Serializable {}

}
