package cn.duchaoqun.Chapter12

object Demo15 extends App {
  // 高阶函数 foreach ，将一个函数应用到集合中的所有元素，没有返回结果。
  (1 to 9).map("*" * _) foreach (println(_))

  args.foreach(arg => println(arg))           // 写法1：
  args.foreach((arg: String) => println(arg)) // 写法2：好理解的方式
  args.foreach(println)                       // 写法3：更为紧凑的写法
}
