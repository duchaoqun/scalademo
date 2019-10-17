package cn.duchaoqun.Chapter10

object Demo13 extends App {

  // 当特质扩展类时，编译器能够确保的一件事是所有混入该特质的类都认这个类作为父类。

  // Scala 还有一套机制可以保证这一点：自身类型（self type）
  // 当特质以如下代码开始定义时：
  // this: 类型 =>

  trait Logged {
    def log(msg: String)
  }

  // 注意该特质并不扩展 Exception 类，而是有一个自身类型 Exception，这意味着它只能被混入 Exception 的子类。
  // 如果你把该特质混入一个不符合自身类型要求的类时，就会报错。
  trait LoggedException extends Logged {
    this: Exception =>
    override def log(msg: String) {
      // 在特质的方法中，我们可以调用该自身类型的任何方法。
      log(getMessage)
    }
  }

  // 带有自身类型的特质和带有父类型的特质很相似，两种情况都能确保混入该特质的类能够使用某个特定类型的特性。
  // 在某些情况下自身类型这种写法比父类型版本更加灵活，自身类型可以解决特质之间的循环依赖（如果你有两个彼此需要的特质时）。


  // 自身类型也同样可以处理“结构类型（structural type）”，这种类型只给出类必须拥有的方法，而不是类的名称。
  // 这个特质可以被混入任何拥有 getMessage 方法的类。
  // trait LoggedException1 extends Logged {
  //   this: {def getMessage: String} =>
  //   {
  //     def log(msg: String) {
  //       getMessage()
  //     }
  //   }
  // }

}
