package cn.duchaoqun.Chapter10

import java.io.PrintWriter
import java.util.Date

object Demo10 extends App {

  // 和类一样，特质也可以有构造器，由字段的初始化和其他特质体重的语句构成。

  trait Logger {
    def log(msg: String) {}
  }

  trait ShortLogger extends Logger {
    val maxLength = 15

    override def log(msg: String): Unit = {
      super.log(
        if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
    }
  }

  trait FileLogger extends Logger {
    val out = new PrintWriter("app.log") // 这是特质构造器的一部分。
    out.println("# " + new Date().toString) // 这同样是构造器的一部分。

    // 定义一个过程
    override def log(msg: String) {
      out.println(msg)
      out.flush()
    }
  }

  class Account(balance: Double = 0.0)

  class SavingAccount extends Account with FileLogger with ShortLogger {}

  // 这些语句在任何混入该特质的对象构造时，都会被执行。

  // 构造器以如下顺序执行：
  // 1. 父类 Account 的构造器。
  // 2. 特质构造器 在父类 Logger 构造器之后，SavingAccount 构造器之前。这里执行 Logger（第一个特质的父特质）。
  // 3. 特质由左到右被构造，这里执行 FileLogger（第一个特质）。
  // 4. 每个特质中，父特质先被构造，如果多个特质有相同的父特质，则该父特质只会被构造一次，这里执行 ShortLogger（第二个特质），注意它的父特质 Logger 已经被构造。
  // 5. 所有特质构造完成，子类被构造，这里执行 SavingAccount。

  // TODO 需要加深研究。
}
