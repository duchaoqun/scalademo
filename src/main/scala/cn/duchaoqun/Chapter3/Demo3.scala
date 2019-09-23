package cn.duchaoqun.Chapter3

object Demo3 {
  val strArray = Array("one", "two", "three")
  for (i <- strArray.indices) { //todo indices 返回一个Range,里面是所引值?
    println(strArray(i))
  }
}
