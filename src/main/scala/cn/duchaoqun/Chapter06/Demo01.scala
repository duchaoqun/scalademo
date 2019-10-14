package cn.duchaoqun.Chapter06

object Demo01 extends App {

  object Accounts {
    private var lastNumber = 0

    def newUniqueNumber(): Int = {
      lastNumber += 1
      lastNumber
    }
  }
  // 对象的构造器在对象第一次使用的时候被创建，如果一个对象从来没有被使用，那么他的构造器也不会被执行。
  Accounts.newUniqueNumber()
}