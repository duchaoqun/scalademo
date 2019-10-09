package cn.duchaoqun.Chapter12

object Demo23 extends App {
  // collect 返回 Vector(asdf)  这个里面其实就是一个偏函数
  println((1 to 5).collect {
    case 1 => "asdf"
  })
}
