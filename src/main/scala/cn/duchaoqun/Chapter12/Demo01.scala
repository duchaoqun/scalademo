package cn.duchaoqun.Chapter12

object Demo01 {

  // 设定一个状态
  var state = true

  // 使用 def 关键字来定义没有参数列表的方法，返回具体类型（非Unit类型）时候，可以省略小括号。
  // 要点：根据习惯，在定义方法的时候我们都写上返回值类型。
  def methodA: String = {
    // 不推荐使用 return 关键字显示的返回结果。
    // return "Scala"
    // 函数体最后一行表达式的结果就是整个函数的返回结果，不要使用 return 语句。
    "Scala"
  }

  // 定义返回类型是 Unit 的方法，不能省略小括号，可以使用下面的过程。
  def methodB(states: String): Unit = {
    states match {
      case "0" => state = false
      case "1" => state = true
      case _ => state = false
    }
  }

  // 假如方法的结果类型是 Unit，执行它的目的就是为了它的副作用（改变方法外的字段状态）就可以去掉结果类型和等号，定义过程
  def produce1() {
    state = false
  }

  // 假如方法仅计算单个结果表达式，则可以去掉花括号，如果表达式很短，甚至可以和def放在一行（留意是否需要使用function的方式来实现）。
  def methodC(a: Int): Int = a + 1


  // 要点：Function 必须有参数列表（可以为空）。
  // 使用 val 关键字来定义一个无参函数。
  val functionA: () => Unit = () => println("Scala")
  val functionC: () => Unit = () => state = false

  // 使用 val 关键字来定义一个有参 Function。
  val functionB: Int => Int = (x: Int) => x * x


  // 程序入口方法：
  def main(args: Array[String]): Unit = {
    methodA // 要点：调用没有参数列表的方法的时候，可以省略小括号。
    methodB("1")
    functionA() // 要点：调用没有参数的函数的时候，需要携带小括号。
  }
}
