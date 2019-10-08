package cn.duchaoqun.Chapter15

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import com.fasterxml.jackson.databind.BeanProperty


/**
  * 1. 什么是注解？
  *
  * 注解可以让你在程序的各个条目中添加信息，这些信息可以被编译器或者外部工具处理。
  * 注解是那些你插入到代码中以便有工具可以对他们进行处理的标签。
  * 工具可以在代码级别运作，也可以处理被编译器加入了注解信息的类文件。
  */
object Demo1 extends App {


  /**
    * 你可以对 Scala 类使用 Java 注解
    * 你也可以使用 Scala 特有的注解（通常由 Scala 编译器或者编译器插件处理）。
    * Java 注解并不影响编译器如何将源码编译成字节码，它仅仅是向字节码中添加数据，以便外部工具可以使用它们。
    * 而在 Scala 中，注解可以影响编译过程。
    */
//  @Entity class Credentials {
//    @Id
//    @BeanProperty var username: String = _
//    @BeanProperty var password: String = _
//  }

}
