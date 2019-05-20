package info.aoye.Chapter7

/**
  * 7.2 作用域规则
  */
object Demo7_2 extends App {

}

package info{
  package aoye {
    class C1{
    }
  }
}

package info{
  package aoye {
    class C2{
      val c1 = new C1 // 在同一级可以使用相对，但是这样做会产生歧义。
      val c1_1 = new info.aoye.C1 // 正常我们应该使用绝对路径来引用，优秀的程序员需要使用完整的包名来引用。
    }
  }
}