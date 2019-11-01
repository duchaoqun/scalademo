package cn.duchaoqun.Chapter10

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