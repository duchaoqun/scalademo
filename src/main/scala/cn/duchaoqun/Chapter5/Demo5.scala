package cn.duchaoqun.Chapter5

/**
  * 重点：
  * 1. Class中的字段自动带有getter和setter方法
  * 2. 你可以用定制的getter/setter方法替换掉字段的定义，而不必修改使用类的客户端（所谓的同意访问原则）
  * 3. 用@beanProperty注解来生成JavaBeans的getXxx/setXxx方法。
  */
object Demo5 extends App {
  // 1. 使用class关键字定义一个类，然后使用new class的方式创建这个类的对象。
  // 2. 定义一个class，然后再定义一个同名的object，这个 class 就是 object 伴生类，同名的 object 就是 class 的伴生对象(存放静态方法，隐式转换等内容)。
  // 3. 伴生的 object 中的内容都是 class 的静态内容，也就是说 Object 中的内容，class 都可以在没有实例的时候直接调用。
  // 4. 正是因为可以在没有类的实例对象的时候，可以直接调用 object 中的一切，所以可是使用 object 中的特定方法来创建实例，这个特定方法就是 apply(object中的apply方法是class对象生成的工厂方法，用来控制对象的生成)。
  // 5. apply具有类的对象生成的一切的生杀大权，抽象类不可以直接实例化，在apply方法中可以实例化抽象类的子类，以Spark中的图计算为例，
  //    Graph是抽象class，在object Graph中的apply方法实际上是调用了Graph的子类GraphImpl来构建Graph类型的对象实例的，
  //    当然Spark图计算的源代码可以看出，GraphImpl的构造也是使用了object GraphImpl的apply方法。
  // 6. 在定义 scala 的 class 的时候，可以直接在类名后面()加入类的构造参数，此时在apply的方法中也必须有这些参数。
  // 7. 辅助构造器是可选的，他们的名字都叫做this




}
