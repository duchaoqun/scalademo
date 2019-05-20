package info.aoye.Chapter6

/**
  * 6.6 枚举
  * 这里需要深入学习一下。
  */
object Demo6_6 extends App {
  println(TrafficLightColor.Red)
}

object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}
