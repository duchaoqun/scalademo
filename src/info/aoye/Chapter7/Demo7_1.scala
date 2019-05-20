package info.aoye.Chapter7

/**
  * 7.1 包
  */
object Demo7_1 {

}

// 要添加一个类到包中，你可以写在不同的源文件中
// 使用这个方式你可以扩展很多包的内容
// 在调用的时候可以使用全路径来引用，可不可以使用相对路径来引用呢？
// 也可以在一个文件中对多个包进行扩展，类似如下的书写方式。

package info{
  package aoye{
    package pkg1{
      class Test1{

      }
    }
  }
}

package info{
  package aoye{
    package pkg2{
      class Test1{

      }
    }
  }
}


