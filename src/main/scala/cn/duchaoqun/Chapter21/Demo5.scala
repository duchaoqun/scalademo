package cn.duchaoqun.Chapter21

/**
  * 21.5 隐式参数
  *
  * 隐式参数是指 class function method 带有一个用 implicit 修饰的参数列表，编译器会查找默认值。
  * 我们可以在定义隐式参数的时候直接指定默认值。
  * 在调用包含隐式参数的方法时，在调用的地方上下文必须有合适的隐式值，否则编译器报错。我们也可以手动为该参数添加默认值。
  * 可以创建一个类用来存放所有的隐式内容，然后 import 这些内容。
  *
  * 注意：隐式参数并不是用于类型转换的，更多的是为了减少代码量。
  * 注意：一个方法只会有一个隐式参数列表，置于方法的最后一个参数列表，如果方法有多个隐式参数，只需一个implicit修饰即可。
  */
object Demo5 extends App {

  case class Delimiters(left: String,right: String)


  def quote(what: String)(implicit delimiters: Delimiters) = {
    delimiters.left + what + delimiters.right
  }

  // 你可以用一个显示的 Delimiters 参数来调用 quote 方法：
  // 注意：这里有两个参数列表，这个函数是【柯里化】的。
  println(quote("Scala")(Delimiters("<",">")))  // <Scala>


  // 我们也可以省去隐式参数列表
  // 这时编译器会查找一个类型为 Delimiters 的隐式值，这必须是一个被声明为 implicit 的值。编译器会在如下两个地方查找这样的一个值。
  // 1. 在当前作用域所有可以用单个标识符指代的满足类型要求的 val 和 def 。
  // 2. 与所要求类型相关联的类型的伴生对象。相关联的类型包括所要求类型本身，以及它的类型参数（如果它是一个参数化的类型的话）。
  implicit val delimiters: Delimiters = Delimiters("<<",">>") // 在当前作用域声明，也可以在所要求类型的伴生对象中声明，或者单独一个【单例对象】中声明。
  println(quote("Scala"))

  // todo:
  class Test(id:Int)(implicit name:String)


  // 在当前上下文中定义一个隐式变量，
  implicit val defaultRate: Float = 0.08F
  // 隐式参数列表中的一个参数指定了默认值，如果上下文没有该类型的隐式变量，才会使用这个默认值。
  def calcTex1(amount:Float)(implicit rate:Float = 0.01F):Float = amount * rate
  calcTex1(1000.0F)
  implicit def calcTex2(amount:Float)(implicit rate:Float = 0.01F):Float = amount * rate
  println(calcTex2(2000))



}
