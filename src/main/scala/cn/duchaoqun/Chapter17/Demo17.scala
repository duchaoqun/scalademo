package cn.duchaoqun.Chapter17

/**
  * 在 Java 中 List<String>和 List<Int> 类型是不一样的，但是 jvm 在编译时会进行"泛型擦除"。
  * 导致 List<String> 和 List<Int> 都是 Class<List> 为了得到正确的类型，需要通过反射。
  * Java 中的泛型基本上都是在编译器这个层次来实现的，在生成的 Java 字节码中是不包含泛型中的类型信息的。
  * 使用泛型的时候加上的类型参数，会在编译器编译代码的时候去掉，这个过程就称为类型擦除。
  * 泛型擦除是为了兼容 jdk1.5 之前的 jvm，在这之前是不支持泛型的。
  *
  * 用于指定类可以接受任意类型参数。参数的类型在实际使用时才被确定，泛型可以有效的增强程序的适应性，使用泛型可以使得类或者方法具有更强的通用性。
  * 1. 定义类的时候，在类的名字后面添加"类型参数"([A,B]) 表明对这个类的参数(主构造函数传递过来的对象类型)进行限定(界定)。
  * 2. 例如 Animals 类的类型参数为 [A,B] 限定参数的类型为 A 和 B 类型。这个类的构造过程需要传递两个对象，一个 A 类型，一个 B 类型。
  * 3. 对于A 和 B 到底是什么类型需要在执行的时候才才能确定。
  * 4. 在实际运行的时候会擦出这个类型参数，仅在编译的时候有效。
  */
object Demo17 extends App {

}
