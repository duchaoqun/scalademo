package cn.duchaoqun.Chapter02

object Exercise extends App {

  println("1. 一个数字如果是正数，则它的signum为1； 如果是复数，他的signum为-1； 如果是0，则signum为0。")
  def signum(arg: Int): AnyVal = if (arg > 0) 1 else if (arg < 0) -1 else if (arg == 0) 0
  println(signum(10))

  println("2. 一个空的块表达式{}的值是什么？类型是什么？")
  println("2. 类型是Unit，没有值")

  println("3. 指出在Scala中什么情况下赋值语句 x = y = 1 是合法的。（提示：给x找个合适的类型定义）")
  var x: Unit = {}
  var y = 0
  x = y = 1
  // {} 空的块表达式返回的结果是Unit类型，赋值语句=返回的类型也是Unit类型。

  println("4. 针对下列Java循环编写一个Scala版：")
  println("for(int i = 10; i >=0; i--  System.out.println(i)")
  for( x <- (1 to 10).reverse) println(x)
  // 10 to 1 是不能用的，这里需要使用1 to 10 然后反转Range。

  println("5. 编写一个过程countdown(n:Int)，打印从n到0的数字")
  def countdown(n:Int): Unit ={
    (0 to n).reverse.foreach(println)
  }
  countdown(10)

  println("6. 写一个for循环，计算字符串中所有字母的Unicode代码的乘积。举例来说，“Hello”中所有字符的乘积是9415087488L")
  var res:Long = 1
  for (x <- "Hello") res *= x.toLong
  println(res)

  println("7. 再次解决练习5的问题，这次不使用循环。（提示：在Scaladoc中查看StringOps）")
  var res1:Long = 1
  "Hello".foreach(res1 *= _.toLong)
  println(res1)

  println("8. 编写一个函数product(s:String），计算前面练习中的乘积。")
  def product(s:String):Long = {
    var res:Long = 1
    "Hello".foreach(res *= _.toLong)
    res
  }

  println("9. 把前一个练习中的函数改成递归函数。")
  def product1(s:String):Long = {
    if(s.length ==1) return s.charAt(0).toLong
    else{
      s.take(1).charAt(0).toLong * product1(s.drop(1))
    }
  }

  println("10. 编写函数计算x的n次,其中n是整数，使用如下的递归定义：")
  println("这个题的细节先略过")
  def mi(x:Double,n:Int):Double={
    if(n == 0) 1
    else if (n > 0 && n%2 == 0) mi(x,n/2) * mi(x,n/2)
    else if(n>0 && n%2 == 1) x * mi(x,n-1)
    else 1/mi(x,-n)
  }
}
