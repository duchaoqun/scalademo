package cn.duchaoqun.Chapter06

object Demo06 extends App {

  object TrafficLightColor extends Enumeration {
    val Red, Yellow, Green = Value
  }
  println(TrafficLightColor.Red)
}


