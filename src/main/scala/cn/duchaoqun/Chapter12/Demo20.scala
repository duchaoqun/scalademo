package cn.duchaoqun.Chapter12

object Demo20 extends App {
  // reduceRight 集合中最右边两个数相减(4 - 5), 然后右边第三个数减去这个结果, 然后右边第四个数再减去这个结果, ...
  println((1 to 5).reduceRight(_ - _))
  println((1 to 5).reduceRight((a, b) => a - b))
  println((1 to 5).reduceRight((a, b) => {
    println(s"$a - $b")
    a - b
  }))
}
