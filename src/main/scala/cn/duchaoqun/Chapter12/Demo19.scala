package cn.duchaoqun.Chapter12

object Demo19 extends App {
  // reduce 集合中第一个数减去第二个数, 结果再减去第三个数, 然后结果再减去第四个数... todo 默认就是reduceLeft??
  println((1 to 5).reduce(_ - _))
  println((1 to 5).reduce((a, b) => a - b))
  println((1 to 5).reduce((a, b) => {
    println(s"$a - $b")
    a - b
  }))
}
