package cn.duchaoqun.Chapter18

object Demo11 extends App {

  // Config特质定义了 load 方法和 text 值，load 方法在实例化时将被执行，用于载入配置信息。
  trait Config {
    load()
    val text: String

    def load(): Unit
  }

  // 一个具体的配置类型定义为 InMemoryConfig ，它定义了具体的 Config 行为。
  trait InMemoryConfig extends Config {
    lazy val text = "Hello"

    override def load(): Unit = {
      println("load: " + text)
    }
  }

  // Context 特质用来表示蛋糕模式的内容对象
  trait Context

  // MyContext 特质使用 this 子类型注解（self type annotation）指定 Config 类型将被混入到当前类或对象中，于是 Config 特质中的数据和方法就好像是定义在该特质中的一样。
  trait MyContext extends Context {
    this: Config =>
    def welcome: String = this.text
  }

  // Env 这个对象是单例模式在 Scala 中的语法化表示，它继承了混入 InMemoryConfig 特质的 MyContext，它很好的表示了依赖嵌入环境。
  object Env extends MyContext with InMemoryConfig

  println(Env.text)

  /*
  蛋糕模式（cake pattern）的优缺点
  1. 没有使用框架，仅使用语言特性
  2. 类型安全——缺失的依赖项在编译时被发现
  3. 功能强大——通过实现合适的依赖提供方法进行协助嵌入
  4. 缺点是代码模板复杂
   */
}
