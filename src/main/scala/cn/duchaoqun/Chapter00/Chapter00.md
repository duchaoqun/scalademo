### 历史
### 应用案例
### 环境准备

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
