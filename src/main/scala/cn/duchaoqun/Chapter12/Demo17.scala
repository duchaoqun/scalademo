package cn.duchaoqun.Chapter12

object Demo17 extends App {
  // 高阶函数 reduceLeft，接受一个二元函数，处理集合中前两个元素，处理所得的一个结果作为与第三个元素继续处理，依次到最后一个元素。
  // 如果两个参数分别在函数体中使用一次，可以使用两个下划线分别代表一个参数。


  // 集合中第一个数减去第二个数, 结果再减去第三个数, 然后结果再减去第四个数...
  val res1 = (1 to 9 ).reduceLeft(_ - _)  // (((1 - 2) - 3 ) - 4 ... - 9
  val res2 = (1 to 9).reduceLeft((a, b) => a - b)


  // 针对数字，依次计算乘法。
  val res3 = (1 to 9).product
}
