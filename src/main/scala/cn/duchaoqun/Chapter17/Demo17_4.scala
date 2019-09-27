package cn.duchaoqun.Chapter17

/**
  * 17.4 视图界定【View bounds】
  *
  * 1. 可以认为是【类型参数】的上下界定的加强版。
  * 2. View Bounds视图界定，可以进行某种神秘的转换，把你的类型可以在没有直觉的情况下，转换成为目标类型。
  * 3. 例如在 SparkContext 这个核心类中，有 T <% Writable 方式的代码，这个代码所表达的是 T 必须是 Writable 类型的。
  *    但是 T 没有直接继承自 Writable 接口，此时就需要通过"implicit"的方式来实现这个功能。
  * 2. 2.12.0以后过期
  */
object Demo17_4 extends App {

  // 定义一个使用上界类型参数的类
  class Pair1[T <: Comparable[T]](first: T, second: T) {}

  // val p1 = new Pair1[Int](2,4)
  // 这里会提示 Int 类型不符合类型参数绑定规则 T <: Comparable[T]
  // 这是因为在 Scala 里面 Int 类型并不是 Comparable 的子类型
  // 不过 RichInt[Int] 实现了 Comparable[Int]，同时还有一个 Int 到 RichInt 的隐式转换

  // 使用视图界定 View bounds 在 2.13.0 以后有更好的实现方法
   class Pair2[T <% Comparable[T]](first: T, second: T) {}
   val p2 = new Pair2[Int](2, 4)


  // 举例：

  // 定义隐式转换来支持视图界定
//  implicit def dog2Person(dog:Dog) = new Person(dog.name)
//
//  class Person(name:String){
//    def talk(person:Person): Unit ={
//      println(this.name + " : " + person.name)
//    }
//  }
//  class Worker(name:String) extends Person(name){}
//
//  class Dog(val name:String){}
//
//  // 类型参数使用视图界定，需要是 Person 的子类型。
//  class Club[T <% Person](p1:T,p2:T){
//    def communicate():Unit = p1.talk(p2)
//  }
//
//  val w = new Worker("Spark")
//  val d = new Dog("Dog")
//
//  val res = new Club[Person](w,d)



  // todo: 应该使用如下方式来实现。
  //class Pair[T](first: T, second: T)(implicit : T => Comparable[T]) {}


}
