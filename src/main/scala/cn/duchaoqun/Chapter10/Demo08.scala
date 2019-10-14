package cn.duchaoqun.Chapter10

object Demo08 extends App {

  trait Mouth {
    // 在 Trait 中定义属性(不包含值)需要在子类提供实现的值，这就是抽象的属性。
    val size: String // 大嘴 小嘴

    // 在 Trait 中定义属性(含值)
    val status: String = "关闭" // 默认嘴可以都是闭着的。


    // 在 Trait 中定义抽象方法(包含实现代码)，可以不在子类中实现该方法，直接调用。
    def look(message: String): Unit = {
      println(message)
    }
  }

  class Dog extends Mouth {
    // 必须实现父特质的抽象内容
    override val size: String = "大嘴"

    def getStatus: String = {
      // 这里的的 status 属性是从上面特质中“继承”下来的，但在 JVM 这个字段是被直接添加到此类当中的，相当于在这里声明了一个 status 变量。
      // 注意：如果继承的是 class 那么这个属性实际还在父类中，这里跟继承 trait 是又本质上的差别的。
      status
    }
  }

}
