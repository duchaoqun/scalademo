package cn.duchaoqun.Chapter07
{
  object Demo02 extends App {

  }
}

package cn{
  package duchaoqun {
    package Chapter07{
      class C1{
      }
    }
  }
}

package cn{
  package duchaoqun {
    package Chapter07{
      class C2{
        val c1 = new C1                          // 在同一级可以使用相对，但是这样做会产生歧义。
        val c1_1 = new cn.duchaoqun.Chapter07.C1 // 正常我们应该使用绝对路径来引用，优秀的程序员需要使用完整的包名来引用。
      }
    }
  }
}