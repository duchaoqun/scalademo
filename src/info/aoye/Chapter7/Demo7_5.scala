package info.aoye.Chapter7

/**
  * 7.5 包对象
  * 包可以包含class object trait 但是不能包含函数和变量的定义，很不幸，这是Java虚拟机的局限。
  * 把工具函数或常量添加到包而不是某个Utils对象，这是更加合理的做法。这时候就可以使用包对象。
  */
object Demo7_5 extends App {
  // 跳转到源代码info.aoye.Chapter7.package.scala文件

  // 下面就可以直接使用包对象中的内容了。
  val name = defaultName

  println(name)

  // 在其他地方使用需要调用完整的路径即可
  // val name = info.aoye.Chapter7.defaultName
}
