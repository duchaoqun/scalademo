package cn.duchaoqun.Chapter7

/**
  * 7.6 包可见性
  */
object Demo7_6 extends App {
  // 在Java中，没有被声明为public、private、protected的类成员在包含该类的包中可见。在Scala中也是这样的。
}

class Chapter7_1{
  //TODO 这里需要学习
  // 添加修饰符，尽在自己的包中可见
//  private[Demo7_6] def description = {
//    "Scala"
//  }
  // 将可见性延申到上层包
//  private[Chapter] def description1 = {
//    "Scala"
//  }
}
