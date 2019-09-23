package cn.duchaoqun.Chapter3

/**
  * 1. Scala会默认添加对Array包的引用。
  * 2. Array对象本身在底层实是不可变的!!! 虽然元素不能删减! 但是我们可以修改元素的内容!!!
  * 3. 如果我们想使用可变数组的话，首先需要导入scala.collection.mutable.ArrayBuffer，然后使用 ArrayBuffer 这个可变数组。
  * 4. 关于ArrayBuffer增加元素，默认都是在末尾增加元素的，所以效率非常高。
  */
object Demo3 {
  val strArray = Array("one", "two", "three")
  for (i <- strArray.indices) { //todo indices 返回一个Range,里面是所引值?
    println(strArray(i))
  }
}
