package cn.duchaoqun.Chapter05

object Demo05 extends App {
  // import scala.reflect.BeanProperty // 过期
  import scala.beans.BeanProperty      // 当前版本为2.13.0

  // 在主构造器中使用
  class Person(@BeanProperty var name:String){
    // 引入包之后，填完注解即可
    @BeanProperty
    var age:Int = _
  }

  val p1 = new Person("Scala")
  val p2 = new Person("Java")

  println(p1.getName)
  println(p2.getName)

  /*
  Scala 字段的常用内容：
  1. val/var 修饰的字段
     生成公有的 name 和 name_= 方法（限于var）
     一般用于可以被公开访问且背后是以字段的形式保存的属性。

  2. @BeanProperty 修饰的字段
     生成公有的 name 和 getName 和 name_= 方法（限于var）和 setName 方法（限于var）
     一般由于与 Java 的互操作。

  3. private val/var 修饰的字段
     生成私有的 name 和 name_= 方法（限于var）
     用于将字段访问限制在本类的方法，就和 Java 一样。注意：尽量使用 private ，除非你真的需要一个公有的属性。

  4. private[this] val/var
     什么都不生成
     用于将字段访问限制在同一个对象上调用的方法，并不经常用到。

  5. private[类名] val/var
     生成什么依赖于具体实现
     将访问权赋予外部类，并不经常用到。
   */
}


