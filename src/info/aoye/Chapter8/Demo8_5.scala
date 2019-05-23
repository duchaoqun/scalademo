package info.aoye.Chapter8

/**
  * 8.5 父类的构造
  * Chapter5中说名了，一个类有一个主构造器，和任意多个辅助构造器。而每个辅助构造器必须以调用主构造器开始。
  * 这样带来的后果是辅助构造器永远也不能调用父类的构造器。
  */
object Demo8_5 extends App {

}

class Demo8_5_1(name:String, age:Int){

}

/**
  * 这段代码定义了一个子类Employee，他的主构造器有三个参数。
  * 其中有两个参数name和age被传递到父类的主构造器中。
  * @param name
  * @param age
  * @param salary
  */
class Employee(name:String, age:Int, val salary:Double) extends Demo8_5_1(name, age){
}

//scala继承Java类的时候，它的主构造器必须调用Java父类的某一个构造方法。
class Square(x:Int, y:Int, width:Int) extends java.awt.Rectangle(x, y, width, width)