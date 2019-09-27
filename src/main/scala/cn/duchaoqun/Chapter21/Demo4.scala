package cn.duchaoqun.Chapter21

/**
  * 21.4 隐式转换规则
  *
  * 隐式转换在发生如下三种各不相同的情况时，会被考虑。
  *
  */
object Demo4 extends App {

  // 1. 当表达式的类型与预期类型不相同的时候。

  // 根据 21_3 代码说明如下：dogList.addOne(p1)
  // p1 是 Person 类型，但是dogList 是 List[Dog] 类型，addOne 方法的预期类型是 Dog 类型，传入 Person 类型的 p1 会寻找有效的隐式函数。


  // 2. 当对象访问一个不存在的成员的时候。

  // 根据 21_2 代码说明如下：val file: String = new File("test.txt").read
  // File 类型没有 read 方法，这时就需要寻找包含read 方法的隐式转换函数（Source类型 是 File 类型，Target 类型 存在read方法）。
  //


  // 3. 当对象调用某个方法，而该方法的参数声明与传入的参数 类型不匹配时。



  // 另外：有三个情况编译器不会尝试使用隐式转换。

  // 1. 代码可以在不使用隐式转换的情况下编译通过，如果 a * b 能编译成功，就不会尝试 a * convert(b) 或者 convert(a) * b
  // 2. 编译器不会同时执行多个转换，例如convert1( convert2(a) ) * b
  // 3. 存在二义性的转换会出错，例如： a * convert(b) 或者 convert(a) * b 都是合法的。

}
