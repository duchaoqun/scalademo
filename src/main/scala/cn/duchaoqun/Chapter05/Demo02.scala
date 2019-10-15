package cn.duchaoqun.Chapter05

object Demo02 extends App {

  class Person {

    val NAME = "Scala"

    // Scala 对 class 中的每个字段都提供"getter" and "setter" 方法
    // var 类型的字段可以被赋值，在创建的对象后，这里的 age 可以被赋值。
    var age = 0

    // 你可以用定制的 getter/setter 方法替换掉默认的定义，而不必修改使用类的客户端（所谓的统一访问原则）。
    // 私有的成员，他的 getter/setter 方法也是私有的。
    private var privateRate = 0.0
    // 自定义的 getter 和 setter 方法。
    def rate: Double = privateRate
    def rate_= (newVale: Double) { if (newVale > privateRate ) privateRate = newVale} // 评分不能降低。

    // TODO：  用@beanProperty注解来生成JavaBeans的getXxx/setXxx方法。
  }

  val person = new Person
  // 在 Scala 中，age 字段的 getter 和 setter 方法分别是叫做 age 和 age_=  //TODO, 书中的 age_= 是什么？
  person.age = 21 // 调用setter方法
  println(person.age) // 调用getter方法

  // 使用自定义的 getter 和 setter
  // 在 Java 中一般定义为 getXxx/setXxx ，在 Scala 中则不是，不过它们的意思是相同的。
  person.rate
  person.rate = 2.0

  // Scala 对每个字段都生成 getter/setter 方法，听上去有些恐怖，不过我们可以控制这个过程。
  // 如果字段是私有的，那么 getter/setter 也是私有的。
  // 如果字段是 val 修饰，那么只有 getter 被生成。
  // 如果你不需要 getter/setter ，可以将字段声明为 private[this] 。




  /*
  使用 javap 查看字节码：
  \ScalaDemo\target\scala-2.13\classes\cn\duchaoqun\Chapter05>javap -private Demo02$Person

  Compiled from "Demo02.scala"
  public class cn.duchaoqun.Chapter05.Demo02$Person {
    private final java.lang.String NAME;
    private int age;
    private int privateHeight;
    public java.lang.String NAME();
    public int age();
    public void age_$eq(int);
    private int privateHeight();
    private void privateHeight_$eq(int);
    public int height();
    public cn.duchaoqun.Chapter05.Demo02$Person();
  }

  编译器会自动创建 如下两个方法，= 等号被翻译成 $eq 因为JVM不允许方法名中出现 = 等号。
    public int age();
    public void age_$eq(int);
  */

}


