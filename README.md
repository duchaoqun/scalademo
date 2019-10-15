# Scala 学习笔记

## Chapter 00 

- 历史
- 应用案例
- 环境准备

## Chapter 01 基础知识

- 基本数据类型介绍
- 基本数据类型 Byte
- 基本数据类型 Char
- 基本数据类型 Short
- 基本数据类型 Int
- 基本数据类型 Long
- 基本数据类型 Float
- 基本数据类型 Double
- 基本数据类型 Boolean
- 基本类型 String
- 基本类型 Option

## Chapter 02 控制结构和函数

- 条件表达式 if
- 语句终止
- 块表达式和赋值
- 输入和输出
- 循环语句 while
- 循环语句 for
- 函数（function）
- 默认参数和带名参数
- 变长参数
- 过程（procedure）
- 懒值（lazy）
- 异常（Exception）

## Chapter 03 Array【数组】

- Array（定长数组，不可变）
- 变长数组（ArrayBuffer）
- 遍历数组 Array 和 ArrayBuffer
- 数组转换
- 常用方法
- 解读ScalaDoc ? TraversableOnce特质
- 多维数组
- Scala 与 Java 的互操作

## Chapter 04 Map and Tuple【映射和元组】

- 创建 Map 对象
- 获取 Map 中的值
- 更新 Map 中的值
- 迭代 Map
- 树形 Map
- Tuple
- zip【拉链操作】

## Chapter 05 class  以及 类型系统

## Chapter 06 object【单例对象与伴生对象】

## Chapter 07 package and import【包和引入】

- 1 package
- 2 作用域规则
- 3 串联式包语句
- 4 文件顶部标记法
- 5 包对象
- 6 包可见性
- 7 import【引入包】
- 8 任何地方都可以引入包
- 9 重命名和隐藏方法
- 10 隐式引入

## Chapter 08 extends

## Chapter 09 文件和正则表达式

## Chapter 10 Trait

- 为什么没有多重继承？
- 当作 Interface 使用的 Trait。
- 带有具体实现的 Trait
- 对象“混入”特质。
- 叠加在一起的特质。
- 在特质中重写抽象方法。
- 当作富接口使用的特质。
- 特质中的具体字段
- 特质中的抽象字段

## Chapter 11 操作符

- 11.1 标识符（感觉这个应该放在最前面来说）
- 11.2 中置操作符（二元操作符）
- 11.3 一元操作符
- 11.4 赋值操作符
- 11.5 操作符优先级
- 11.6 操作符结合性
- 11.7 apply 和 update 方法
- 11.8 提取器
- 11.9 带单个参数或无参数的提取器
- 11.10 unapplySeq 方法

## Chapter 12 Method and Procedure and Function（方法、过程、函数）

- 关于方法、过程、函数，以及它们之间的区别
- 定义方法、过程、函数
- 有参数的函数 - 斐波那契数列
- 使用默认参数的函数
- 可变长的参数
- 参数“类型”推断
- 使用“函数作为参数”的函数
- 函数的结果类型
- 将函数赋值给 val 变量
- 使用匿名函数
- 高阶函数 collect
- 高阶函数 filter
- 高阶函数 flatMap
- 高阶函数 foldLeft
- 高阶函数 foldRight
- 高阶函数 foreach
- 高阶函数 map
- 高阶函数 reduce
- 高阶函数 reduceLeft
- 高阶函数 reduceRight
- 柯里化
- 副作用（side effect）

## Chapter 13 Collection（集合）

## Chapter 14 模式匹配和样例类

- 1. match case 表达式
- 2. 使用守卫的 match case 表达式
- 3. match case 中的变量
- 4. match case 匹配类型【L2】


## Chapter 15 注解

- 1. 什么是注解？
- 2. 什么可以被注解？
- 3. 注解参数
- 4. 创建注解【TODO】
- 5. 针对Java特性的注解【TODO】
- 6. 用于优化的注解【TODO】
- 7. 用于错误和警告的注解【TODO】

## Chapter 16 XML 处理


## Chapter 17 类型参数

- 17.1 泛型类【使用类型参数(Type parameter)的类】
- 17.2 泛型函数【使用类型参数(Type parameter)的函数和方法】
- 17.3 类型参数的上下界定
- 17.4 视图界定【View bounds】2.12.0以后过期

## Chapter 18 高级类型

## Chapter 19 解析

## Chapter 20 Actor

- 1 创建和启动 Actor
- 2 发送消息到 Actor
- 3 取出 Actor 收到的消息
- 4 向其他 Actor 发送消息
- 5 消息通道【TODO】310页
- 6 同步消息和Future【TODO】311页

## Chapter 21 隐式转换和隐式参数

- 1 隐式转换
- 2 利用隐式转换扩展现有类库的功能
- 3 引入隐式转换
- 4 隐式转换规则
- 5 隐式参数
- 6 利用隐式参数进行隐式转换
- 7 上下文界定【TODO】
- 8 类型证明【TODO】
- 9 @implicitNotFound注解【TODO】 
- 10 CanBuildFrom解读【TODO】

## Chapter 22 定界延续

## Chapter 23 util 类库

- scala.util.Random
- scala.util.Properties
- scala.util.{Try, Success, Failure}
- scala.util.Either
- scala.util.control.Breaks

## Chapter 24 math 类库

## Chapter 25 sys 类库

- scala.sys.process._

