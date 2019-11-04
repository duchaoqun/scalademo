```shell

scala> 1+2        // 在scala里面+号是一个操作符
res0: Int = 3     // shell自动创建一个名为res0的Int类型的变量,它的值是3

scala> res0 * 2   // 在当前的交互环境中,上一步的res0,还能继续使用
res1: Int = 6

scala> println("Hi!")      // 标准打印
Hi!

scala> val msg = "Hi!"     // val修饰的变量,相当于Java中的final类型,一旦赋值,不能更改
msg: String = Hi!          // 自动类型判断能力,自动判断为String类型

scala> val msg:String ="Hello!"  // 指定变量类型来声明内容
msg: String = Hello!

scala> var ma:Int = 123    // var修饰的变量,在生命周期内可以多次被赋值,它是可变的
ma: Int = 123

scala> val oops =
    | "dddd                //使用 | 符号,标识一行没有输入完在下一行继续输入.
```