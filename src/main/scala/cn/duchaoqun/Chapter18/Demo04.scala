package cn.duchaoqun.Chapter18

import scala.collection.mutable


object Demo04 extends App {

  // 对于复杂类型，你可以用 type 关键字创建一个简单的别名：

  class Book {
    type Index = mutable.HashMap[String, (Int, Int)]
  }

  // 这样你就可以用 Book.Index 而不是更笨重的类型scala.collection.mutable.HashMap[String, (Int, Int)]

  // 类型别名必须嵌套在类或对象中，他不能出现在 Scala 文件的顶层。

}
