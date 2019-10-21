package cn.duchaoqun.Chapter15

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import com.fasterxml.jackson.databind.BeanProperty
import com.sun.xml.internal.stream.Entity
import javax.inject.Inject
import org.bouncycastle.util.test.Test

object Demo02 extends App {

  // 给类添加注解
  // @Entity class Credentials1 {}

  // 给方法添加注解。
  // @Test def testSomeFeature() {}

  // 同时添加多个注解，先后次序没有影响。
  // @Id
  // @BeanProperty var username: String = _

  // 给字段添加注解。
  // @BeanProperty var password: String = _

  // 给主构造器添加注解时，你需要将注解放在主构造器之前，并加上一对小括号（如果注解不带参数的话）。
  class Credentials2 @Inject()(var username: String, var password: String)

  // 给表达式添加注解。
  val map1 = Map(1 -> "Scala", 2 -> "Java")

  {
    map1.get(1): @unchecked  // 给表达式添加注解，你需要在表达式后面添加上冒号，然后是注解本身。
  } match {
    case _ => println("None")
  }


  // 给类型参数添加注解
  class MyContainer[@specialized T]

  // 针对实际类型的注解应放置在类型名称之后
  //String @cps[Unit]


}
