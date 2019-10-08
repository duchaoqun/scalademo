package cn.duchaoqun.Chapter15

import java.io.IOException

import com.sun.xml.internal.stream.Entity
import javax.inject.Named
import org.junit.Test


/**
  * 3. 注解参数
  */
object Demo3 extends App {

  // Java 注解可以有带名参数
  @Test (timeout = 100, expected = classOf[IOException])
  def getFile(path:String): Unit ={
    println(path)
  }

  // Java 注解可以有带名参数，如果参数名为 value 可以省略。
  @Named("Scala")
  var Demo3_1: String = _

  // 如果注解不带参数，后面的小括号也可以省略。
  // @Entity
  class Credentials

  // 大多数注解参数都有默认值，例如 JUnit 的 Test 注解 timeout 参数的默认值是0，表示没有超时，而expected参数有一个假的默认类表示不预期任何异常。
  @Test
  def testSomeFeature1(){}
  // 与上面的效果一样
  @Test(timeout = 0, expected = classOf[org.junit.Test.None])
  def testSomeFeature2(){}

  // Java 注解的参数类型只能是：数值型字面量，字符串，类字面量，Java枚举，其他注解，上述类型的数组（但不能是数组的数组）。
  // Scala 注解的参数类型可以是任意类型，但只有少数几个Scala注解使用了这个特性。
}
