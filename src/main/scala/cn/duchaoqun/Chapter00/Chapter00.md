### 历史

背景：整个 IT 编程技术的发展史，其实就是一部封装史。
一. Function 时代：C 语言中提供了函数的概念，把若干条语句进行封装和复用。
二. Class 时代：C(java)等语言提供类的对象，把数据和处理数据业务的逻辑封装起来。
三. 框架时代：最大的封装就是使用框架！把数据，代码和驱动封装起来。

- 联邦理工学院洛桑（EPFL）的 Martin Odersky 于 2001 年基于 Funnel 的工作开始设计 Scala。


### 起点

- 在Scala中所有内容都是对象。
- 推荐使用链式表达式：rdd.map reduce foreach 返回当前对象，这样的链式操作。

```scala
  def setName(_name:String):this.type = {
    name = _name
    this
  }
```

### 应用案例
### 环境准备

### 官方文档

  // 【官方网站】
  // https://www.scala-lang.org/

  // 【官方文档】
  // https://www.scala-lang.org/api/current/    当前最新版本的API文档
  // https://docs.scala-lang.org/api/all.html   各个版本的API文档
  // https://docs.scala-lang.org/tutorials/

  // 【AKKA】
  // https://doc.akka.io/api/akka/2.5.11/akka/index.html

  // 【Play FrameWork 官方文档】
  // https://www.playframework.com/documentation/2.7.x/Home
  // https://www.playframework.com/documentation/2.8.0-M5/Home

  // 【PlaySlick文档】
  // http://slick.lightbend.com/doc/3.2.3/
  // http://slick.lightbend.com/doc/3.2.3/api/index.html#package

  // 【Spark官方文档】
  // http://spark.apache.org/docs/
  // http://spark.apache.org/docs/latest/api/scala/index.html

  // 【其他文档】
  // https://www.scala-js.org/api/scalajs-library/latest/

    //关于方法的调用
    //1. 如果方法不需要参数，那么可以省略括号
    val value1: String = "5".toString()
    val value2: String = "5".toString

    //赋值表达式的返回值是Unit类型,所以不能写作 val a = b =123,这里b=123返回的是Unit
    val str0 = "Hi!"

    //Scala中的数学方法
    println(sqrt(2)) //Stdout：1.4142135623730951


    //关于方法的调用
    //1. 如果方法不需要参数，那么可以省略括号
    val value1: String = "5".toString()
    val value2: String = "5".toString


    //todo 组装注入??
    //todo 胖接口和瘦接口!??
# package 包管理 
    
    使用包来管理项目模块与项目代码,按照目录层次结构编写代码.
    
    ## 包管理
    
    ## 包限制
    
    class SQLContext private[sql] ().....
    
    private[sql] 表明这个类只能在sql包下面使用.
    
    ## 代码与框架隔离开??? 是什么概念???


  // 退出当前程序.
  System.exit(1)

  System.lineSeparator()  // 根据操作系统获取换行符

  // 获取操作系统参数
  val pp = new SystemProperties  // 创建系统参数对象
  println(pp.get("user.dir"))    // 获取系统参数,内容是一个Map对象,get的结果是Some对象

  // 使用系统代理
  System.setProperty("http.maxRedirects", "50")
  System.getProperties.setProperty("proxySet", "true")
  val ip = "127.0.0.1"
  System.getProperties.setProperty("http.proxyHost", ip)
  System.getProperties.setProperty("http.proxyPort", "1080")、
  
  
  
  ## 单元测试
  
  ```scala
    //TODO 类继承中的 " 提前定义 "
    //  class Dog extends {
    //  }with Animals
  ```
  
  设计模式：里氏替换原则【Liskov Substitution Principle，LSP】
  1、子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
  2、子类中可以增加自己特有的方法。
  3、当子类的方法重载父类的方法时，方法的前置条件（即方法的输入/入参）要比父类方法的输入参数更宽松。
  4、当子类的方法实现父类的方法时（重写/重载或实现抽象方法），方法的后置条件（即方法的输出/返回值）要比父类更严格或相等。
  
  ## Demo Jasper Report
  
  使用JasperReport工具生成报表
  
  #### Source 
  
  - FromFile.scala 针对文件的操作
  
  ## Other 
  
  - 解析HTML包：https://jsoup.org/

  
  The difference between method and function? 
  * 7. 技巧: 如果方法的返回类型是Unix,这时就可以省略定义结构中的" :Unit = "
  
  


- Scala 类库里面有 22 个 function 特质。 Function0

  def javaVersion1(): Unit = () => scala.sys.props("java.version") //如返回Unit则需要参数,仅使用方法的副作用处理输入对象
  def javaVersion2 = () => scala.sys.props("java.version") //不需要参数,定义的是方法?
  def test1(): Unit = {
    scala.sys.props("java.version")
  }
  
  // 省略的函数体花括号
  def matchTestA(x: Any): Any = {
    x match {
      case 1 => "one"
      case _ => "many"
    }
  }
  def matchTestB(x: Any): Any = x match {
    case 1 => "one"
    case _ => "many"
  }
  

1. Scala中使用关键字lazy来定义惰性变量，实现延迟加载(懒加载)。
1. 惰性变量只能是不可变变量，并且只有在调用惰性变量时，才会去实例化这个变量。


## Execute Program

执行程序方法：自动找到Main方法
$ java -jar scala-assembly-0.0.1.jar

如果项目有多个入口的时候需要选择执行入口：手动指定Main方法
$ java -cp scala-assembly-0.0.1.jar cn.com.rexen.spark.Hello

## 统一访问原则

某个模块提供的所有服务都应该能通过统一的表示法访问到，至于它们是通过存储还是通过计算来实现的，从访问方式上无法得知。
（当然，在JVM中，服务总是通过方法来实现的，要么是编译器合成的方法，要么由程序员提供）