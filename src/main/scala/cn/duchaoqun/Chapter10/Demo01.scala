package cn.duchaoqun.Chapter10

/**
  * Scala 和 Java 一样不允许类继承多个父类（不能多重继承）。
  * 如果我们只是把两个毫不相关的类组合在一起，这样多重继承没有问题。
  * 但是如果这些类包含共同的方法或者字段，这样就有问题了。
  *
  * 在 Java 中 class 只能扩展一个父类，但是可以实现任意数量的接口，但接口只能包含抽象方法，不能包含字段。
  */
object Demo01 extends App {

  class Person {
    def name: String = "Scala"
  }

  // 定义员工类
  class Employee {
    def id: String = "1"

  }

  // 定义学生类
  class Student {
    def id: String = "2"
  }

  // 再定义一个助教(错误代码)，他即使学生又是员工，这里他就继承了两个 id 方法，使用的时候应该返回什么呢？ 这就是问题。
  // class TeachingAssistant extends Employee, Student


  class Employee1 extends Person {
    def id: String = "1"
  }

  class Student1 extends Person {
    def id: String = "2"
  }

  // 菱形继承问题
  // 如果员工和学生又同时继承 Person 这个类，那么 name 的方法返回的应该是什么呢？ 这就是问题。
}