package cn.duchaoqun.Chapter07

object Demo05 extends App {
  // 跳转到源代码cn.duchaoqun.Chapter07.package.scala文件

  // 下面就可以直接使用包对象中的 defaultName 了。
  val name = defaultName

  println(name)

  // 在其他地方使用需要调用完整的路径即可
  // val name = cn.duchaoqun.Chapter07.defaultName
}
