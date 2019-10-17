package cn.duchaoqun.Chapter10

object Demo14 extends App {

  // 只有抽象方法的特质被简单的变成一个接口。
  trait Logger {
    def log(msg: String)
  }

  // 直接被翻译成
  // public interface Logger {  // 生成的 Java 接口
  //   void log(String msg);
  // }


  // 如果特质有具体的方法，Scala 会帮我们创建出一个伴生类，该伴生类用静态方法存放特质的方法。
  trait ConsoleLogger extends Logger {
    def msg(msg: String) {
      println(msg)
    }
  }

  // 直接被翻译成
  // public interface ConsoleLogger extends Logger{ // 生成的 Java 接口
  //   void log(String msg);
  // }

  // public class ConsoleLogger$class { // 生成的 Java 伴生类
  //   public static void log(ConsoleLogger self, String msg){
  //     println(msg)
  //   }
  // }


  // 这些伴生类不会有任何字段，特质中的字段对应到接口中的抽象的 getter/setter方法，当某个类实现该特质时，字段被自动加入。
  trait ShortLogger extends Logger{
    val maxLength = 15 // 具体的字段
  }

  // 直接被翻译成
  // public interfae ShortLogger extends Logger {
  //   public abstract int maxLength();
  //   public abstract void weird_prefix$maxLength_$eq(int);
  //     ...
  // }
  // 这里以 weird 开头的 setter 方法是需要的，用来初始化该字段，初始化发生在伴生类的一个初始化方法内：
  // public class ShortLogger$class {
  //   public void $init$(ShortLogger self){
  //     self.werid_prefix$maxLength_$eq(15)
  //   }
  // }

  // 当特质被混入类的时候，类会的带一个带有 getter/setter 的 maxLength 字段，那个类的构造器会调用初始化方法。
  // 如果特质扩展自某个父类，则伴生类并不继承这个符类，该父类会被任何实现该特质的类继承。

}
