# Scala 学习笔记

## Chapter 00 

## Chapter 01 基础知识

### Scala 历史
### Scala 应用案例
### Scala 环境准备
### Scala 基本数据类型介绍
### Scala 基本数据类型 String
### Scala 基本数据类型 Float
### Scala 基本数据类型 Char

### 【Demo08】基本类型 Option

## Chapter 02 控制结构和函数

- 2.1 条件表达式 if
- 2.2 语句终止
- 2.3 块表达式和赋值
- 2.4 输入和输出
- 2.5 循环语句 while
- 2.6 循环语句 for
- 2.7 函数（function）
- 2.8 默认参数和带名参数
- 2.9 变长参数
- 2.10 过程（procedure）
- 2.11 懒值
- 2.12 Exception（异常）

## Chapter 03 Array【数组】

- 3.1 Array(定长数组，不可变)
- 3.2 变长数组：数组缓冲
- 3.3 遍历数组Array和缓冲数组ArrayBuffer
- 3.4 数组转换
- 3.5 常用算法
- 3.6 解读ScalaDoc ? TraversableOnce特质
- 3.7 多维数组
- 3.8 Scala与Java的互操作

## Chapter 04 Map【映射】和Tuple【元组】

- 1 Map【映射】
- 2 获取Map中的值
- 3 更新Map中的值
- 4 迭代Map
- 5 SortedMap(树形映射)
- 6 Scala与Java的互操作
- 7 Tuple
- 8 zip【拉链操作】

## Chapter 05 class

## Chapter 06 object

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

## Chapter 08 extends【继承】

- 8.1 扩展类
- 8.2 重写方法
- 8.3 类型检查和转换
- 8.4 受保护的字段和方法
- 8.5 父类的构造
- 8.6 重写字段 
- 8.7 匿名子类
- 8.8 抽象类
- 8.9 抽象字段
- 8.10 构造顺序和提前定义【L3】
- 8.11 继承层级
- 8.12 对象相等性【L1】

## Chapter 09 文件和正则表达式

- 1 读取行
- 2 读取字符
- 3 读取词法单元和数字【略】
- 4 从URL或者其他来源读取数据
- 5 读取二进制文件
- 6 写入文本文件
- 7 访问目录【待定】
- 8 序列化
- 9 进程控制【A2】
- 10 正则表达式
- 11 正则表达式组

## Chapter 10 Trait【特质】

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

## Chapter 12 Function（函数）

## Chapter 13 Collection（集合）

- 13.1 主要的集合特质
- 13.2 可变和不可变集合
- 13.3 Seq(序列)
- 13.4 List(不可变列表)
- 13.5 ListBuffer(可变列表)
- 13.6 Set(集合)
- 13.7 用于添加或删除元素的操作符【TODO】

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

## Chapter 23 类库

- 【Demo01】scala.util.Random
- 【Demo02】java.lang.System

## Demo 



## Demo Jasper Report

使用JasperReport工具生成报表

## Demo

### io

#### Source 

- FromFile.scala 针对文件的操作


## Other 

- 解析HTML包：https://jsoup.org/

## todo

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