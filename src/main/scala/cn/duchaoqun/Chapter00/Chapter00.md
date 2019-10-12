《快学Scala》一书中的内容
- 14.5. 匹配数组、列表、元组【TODO 197】
- 14.6. 提取器【TODO】
- 14.7. 变量声明中的模式【TODO】
- 14.8. for 表达式中的模式【TODO】
- 14.14.11. case语句中的中置表达法【TODO】
- 14.12. 匹配嵌套结构【TODO】
- 14.13. 样例类是邪恶的吗？【TODO】
- 14.14. 密封类【TODO】
- 14.15. 模拟枚举【TODO】
- 14.17. 偏函数【TODO】

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
