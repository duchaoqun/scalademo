package cn.duchaoqun.Chapter12

object Demo25 extends App {
  // 在 Scala 中，我们可以将一系列语句组成不带参数也没有返回值的函数。

  // 如下函数在线程中执行某段代码。
  def runInThread1(block: () => Unit): Unit = {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  // 这段代码以类型为 ()=>Unit 的函数形式给出。不过当你调用该函数的时候，需要些一段不那么美观的 ()=>Unit：
  runInThread1(() => {
    println("Hi")
    Thread.sleep(1000)
    println("Bye")
  }
  )

  // 想要在调用中省略 () => ，可以使用“换名调用”表示法：在参数声明和调用该函数参数的地方省略() ，但是保留 =>
  def runInThread2(block: => Unit): Unit = {
    new Thread {
      override def run() {
        block
      }
    }.start()
  }

  // 这样一来，调用代码就变成了
  runInThread2({
    println("Hi")
    Thread.sleep(1000)
    println("Bye")
  }
  )

  // Scala 程序员可以构建“控制抽象”：看上去像是编程语言的关键字的函数。

  // 举例来说，我们完全可以实现一个用起来完全像是在使用 while 语句那样的函数。或者，我们也可以在发挥一下，定义一个 until 语句，
  // 工作原理类似 while，只不过把条件反过来用。
  def until_1(condition: => Boolean)(block: => Unit): Unit ={
    if (!condition){
      block
      until_1(condition){block}
    }
  }

  var x = 10
  until_1(x == 0){
    x -=1
    println(x)
  }
  // 这样的函数参数有一个专业术语叫做“换名调用”参数。和一个常规的（或者说换值调用）参数不同，函数在被调用时，参数表达式不会被求值。
  // 毕竟，在调用 until_1 时，我们不希望 x == 0 被求值得到 false。与之相反，表达式成为无参函数的函数体，而该函数被当作参数传递下去。
}
