package cn.duchaoqun.Chapter08

object Demo10 extends App {
  // 在一维世界中，假设动物可以感知前方 10 个单位距离的信息。
  class Creature {
    val range: Int  = 10
    val height: Int = 100
    val env: Array[Int] = new Array[Int](range)
  }

  // 不过蚂蚁是近视的，它仅能感知前方 2 个单位。
  class Ant extends Creature{
    override val range = 2
  }
  // 这将面临一个问题：
  // range 的值在父类的构造器中用到了，而父类的构造器要先于子类的构造器运行。事情发生顺序如下：
  // 1. Ant 的构造器在做它自己的构造之前，调用 Creature 的构造器。
  // 2. Creature 的构造器将它的 range 字段值设置为 10。
  // 3. Creature 的构造器为了初始化 env 数组，调用 range() 取值器。
  // 4. range() 方法被重写，以输出（未被初始化的） Ant 类的 range 字段值。
  // 5. range() 方法返回 0 。（这是对象被分配空间时所有整型字段的初始值。）
  // 6. env 被设置为长度为 0 的数组。
  // 7. Ant 构造器继续执行，将其 range 字段设置为 2。

  // 虽然 range 字段看上去可能是 10 或者 2 ，但是 env 被设置成了长度为 0 的数组。
  // 这里的关键点是：在我们的构造器内不应该依赖 val 字段的值。


  // 使用“提前定义”来解决这个问题，可以让你在父类的构造器执行之前初始化子类的 val 类型字段。
  class Ant1 extends {
    override val range = 2
  } with Creature

  // 构造顺序问题的根本原因来自 Java 语言的一个设计决定：即允许在父类的构造方法中调用子类的方法。
}
