package cn.duchaoqun.Chapter18

object Demo05 extends App {

  // 所谓的“结构类型”指的是一组关于抽象方法、字段和类型的规格说明，这些抽象方法、字段和类型是满足该规则的类型必须具备的。

  // 如下方法带有一个结构类型参数 target：

  def appendLines(target: {def append(str: String): Any}, lines: Iterable[String]): Unit = {
    for (line <- lines) {
      target.append(line)
      target.append("\n")
    }
  }

  // 你可以对任何具备 append 方法的类的实例调用 appendLines 方法。这比定义一个 Appendable 特质更灵活，因为你可能并不总是
  // 能够将该特质添加到使用的类上。

  // 在幕后，Scala 使用反射来调用 target.append(...)。
  // 结构类型让你可以安全而方便地做这样的反射调用。

  // 不过，相比常规的调用方法，反射调用的开销要大的多，因此你应该旨在需要抓住那些无法共享一个特质的类的共通行为的时候才使用结构类型。

}
