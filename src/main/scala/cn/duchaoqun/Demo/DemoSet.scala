package cn.duchaoqun.Demo

import scala.collection.mutable

/**
  * 1. 没有重复的对象集合，所有的元素都是唯一的。
  * 2. 对不可变 Set 进行操作，会产生一个新的 Set ，原来的 Set 并没有改变，这与List一样。
  * 3. 而对可变 Set 进行操作，改变的是该 Set 本身，与ListBuffer类似。
  *
  * 参考文档：http://www.runoob.com/scala/scala-sets.html
  */
object DemoSet extends App{
  // 创建一个不可变的 Set
  val immutableSet = scala.collection.immutable.Set(1, 2, 3)

  // 不可变的 Set 添加一个元素
  immutableSet + 1
  // 不可变的 Set 添加一个元素，会返回一个新的不可变Set对象。
  val newImmutableSet = immutableSet + 1
  println(immutableSet)
  println(newImmutableSet)

  // 创建一个可变的 Set
  val mutableSet = collection.mutable.Set(3, 4, 5)
  mutableSet.add(6) // 直接添加元素
  mutableSet += 7 // 直接添加元素

  mutableSet.remove(3) // 直接删除元素
  mutableSet -= 4
  println(mutableSet)


  // 创建一个可变的 Set 对象，最好使用下面的写法。
  val mSet1: mutable.Set[String] = collection.mutable.Set()
  mSet1.add("a")
  mSet1.add("b")
  mSet1.add("c")
  mSet1.add("d")
  println(mSet1)

  mSet1.foreach(x => println(x))

}
