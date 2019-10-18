package cn.duchaoqun.Chapter12

object Demo27 extends App {
  println((1 to 10).scan(0)(_ + _))

  println((1 to 10).scanLeft(0)(_ + _))

  println((1 to 10).scanRight(0)(_ + _))
}
