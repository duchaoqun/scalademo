package cn.duchaoqun.Chapter23

import scala.util.Random

object Demo23_1 extends App {
  // 构造对象
  val random1 = new Random()
  val random2 = new Random(10)
  val random3 = new Random(Long.MaxValue)

  // 单例对象(object)中的常用方法
  println(Random.alphanumeric)   // collection.immutable.Stream[Char] 随机字符?
  println(Random.nextBoolean)    // 随机true and false
  println(Random.nextFloat)      // 0-1之间的浮点数
  println(Random.nextDouble)     // 0-1之间的浮点数
  println(Random.nextInt(100))   // 生成100以内的随机数 [0,100)
}
