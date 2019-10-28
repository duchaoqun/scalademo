package cn.duchaoqun.Chapter18

object Demo03 extends App {
  // 考虑如下类型
  // cn.duchaoqun.Chapter18.Demo02.chatter.Member
  // 或者，如果我们将 Member 嵌套在伴生对象当中的话：
  // cn.duchaoqun.Chapter18.Demo02.Network.Member

  // 这样的表达式我们称为路径。
  // 在最后的类型之前，路径的所有的组成部分必须是“稳定的”，也就是说，它必须指定到单个、有穷的范围，组成部分必须是以下当中的一种：
  // 包
  // 对象
  // val
  // this、super、super[S]、C.this、C.super或C.super[S]

  // 路径组成部分不能是类，因为嵌套的内部类并不是单个类型，而是给每个实例都留出了各自独立的一套类型。

  // 不仅如此，类型也不能是 var 例如：
  // var chatter = new Network
  // val fred = new chatter.Member // 错误，Chatter 不稳定。
  // 由于你可能将一个不同的值赋给 chatter， 编译器无法对类型 chatter.Member 做出明确解读。

  // 在内部，编译器将所有嵌套类型的类型表达式 a.b.c.T 都翻译成类型投影 a.b.c.type#T
  // 举例来说： chatter.Member 就成为 chatter.type#Member  --- 任何位于 chatter.type 单例中的 Member。

  // 这不是你通常需要担心的问题，不过有时候你会看到类型 a.b.c.type#T 的错误信息，将它翻译回 a.b.c.T 即可。

}
