package info.aoye.Chapter10

/**
  * 10.1 为什么没有多重继承？
  * Scala 和 Java 一样不允许类继承多个父类（不能多重继承）。
  * 如果我们只是把两个毫不相关的类组合在一起，这样多重继承没有问题。
  * 但是如果这些类包含共同的方法或者字段，这样就有问题了。
  */
object Demo10_1 extends App {

}

class Demo10_1_0{
  def name:String = "Scala"
}

class Demo10_1_1 {
  def id:String= "1"

}

class Demo10_1_2 {
  def id:String = "2"
}

class Demo10_1_3 extends Demo10_1_1

/*
如果一个类class Demo10_1_3 extends Demo10_1_1,Demo10_1_2 , 这样他就继承了两个id！！！ 到底返回的什么玩意呢？
如果 Demo10_1_1,Demo10_1_2 都继承 Demo10_1_0， 又会有两个name字段，好尴尬！

在Java中 类只能扩展一个父类，但是可以实现任意数量的接口，但接口只能包含抽象方法，不能包含字段。
Scala提供“trait”而不是“interface”，特质可以同时拥有抽象方法和具体方法，而类可以实现多个特质。
 */