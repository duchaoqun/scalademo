package cn.duchaoqun.Chapter07

object Demo09 extends App {
  // 如果你想引入包中的几个成员，你可以使用选择器
  import scala.collection.mutable.{HashMap, HashSet}

  // 选择器还允许我们重新命名类的名称，这样我们就可以使用新的名称
  import java.util.{HashMap => JavaHashMap}


  // 引入 java.util 包中的所有内容，只隐藏HashMap方法，这样我们就可以使用 Scala 的 mutable.HashMap 方法了。
  import java.util.{HashMap => _, _}
  import scala.collection.mutable.HashMap
}
