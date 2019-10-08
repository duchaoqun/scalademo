package cn.duchaoqun.Chapter6

/**
  * 6.1 单例对象
  * Scala 中没有静态方法或者静态字段，你可以使用单例对象来实现。
  * 作为存放工具函数和常量的地方。
  * 高效的共享单个不可变实例。
  * * 定义一个class，然后再定义一个同名的object，这个 class 就是 object 伴生类，同名的 object 就是 class 的伴生对象(存放静态方法，隐式转换等内容)。
  * * 伴生的 object 中的内容都是 class 的静态内容，也就是说 Object 中的内容，class 都可以在没有实例的时候直接调用。
  * * 正是因为可以在没有类的实例对象的时候，可以直接调用 object 中的一切，所以可是使用 object 中的特定方法来创建实例，这个特定方法就是 apply(object中的apply方法是class对象生成的工厂方法，用来控制对象的生成)。
  * * apply具有类的对象生成的一切的生杀大权，抽象类不可以直接实例化，在apply方法中可以实例化抽象类的子类，以Spark中的图计算为例，
  * * Graph是抽象class，在object Graph中的apply方法实际上是调用了Graph的子类GraphImpl来构建Graph类型的对象实例的，
  * * 当然Spark图计算的源代码可以看出，GraphImpl的构造也是使用了object GraphImpl的apply方法。
  * * 1. 用对象作为单例或者存放工具方法
  * * 2. 类可以拥有一个同名的伴生对象
  * * 3. 对象可以扩展类或特质
  * * 4. 对象的apply方法通常用来构造伴生类的新实例。
  * * 5. 如果不想显示定义main方法，可以用扩展App特质的对象。
  * * 6. 你可以通过扩展Enumeration对象来实现枚举。
  */
object Demo1 extends App {
  Accounts.newUniqueNumber() // 对象的构造器在对象第一次使用的时候被创建
}

object Accounts{
  private var lastNumber = 0
  def newUniqueNumber():Int = {
    lastNumber += 1
    lastNumber
  }
}
