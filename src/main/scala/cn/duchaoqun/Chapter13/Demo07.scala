package cn.duchaoqun.Chapter13

object Demo07 extends App {

  // 创建一个迭代器对象，用来演示 Iterable 特质中的方法
  val set = Set("Scala", "Spark", "Java", "Hadoop", "Python", "JS", "C#", "C++")

  // 如下是 Iterable 特质包含的一些方法。
  set.head             // 返回第一个元素
  set.headOption       // 返回第一个元素，以 Option 类型返回。
  set.last             // 返回最后一个元素
  set.lastOption       // 返回最后一个元素，以 Option 类型返回。
  set.init             // 返回除了最后一个元素以外的所有内容。
  set.tail             // 返回除了第一个元素以外的所有内容。
//set.length           // 过期
  set.isEmpty          // 判断是否为空
//set.sum              // 返回元素之和（前提是元素类型可以被隐式转换成 Numeric 特质）
//set.product          // 返回元素乘积（前提是元素类型可以被隐式转换成 Numeric 特质）
  set.min              // 返回最小值（前提是元素类型可以被隐式转换成 Ordered 特质）
  set.max              // 返回最大值（前提是元素类型可以被隐式转换成 Ordered 特质）
  set.size             // 查看大小
  set.iterator         // 返回一个迭代器对象

//set.count()          // 高阶函数参考 Chapter 12 中的内容。
//set.forall()         // 高阶函数参考 Chapter 12 中的内容。
//set.exists()         // 高阶函数参考 Chapter 12 中的内容。
//set.foreach()        // 高阶函数参考 Chapter 12 中的内容。
  // ...


  // 你可以使用 iterator 方法从集合里面获取一个迭代器。
  val iteratorSet = set.iterator

   // 对于iterator 最常用的就是使用 while 来访问内容
   while (iteratorSet.hasNext) { // 调用 it.hasNext() 用于检测集合中是否还有元素。
     println(iteratorSet.next) // 调用 it.next() 会返回迭代器的下一个元素，并且更新迭代器的状态。
   }

  // iterator 只能迭代一次，然后就没有了！！

}
