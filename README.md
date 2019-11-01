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

- 简单类和无参方法
- "getter" and "setter" 属性
- 只有 getter 的属性
- 对象私有字段
- Bean 属性
- 主构造器（primary constructor）
- 辅助构造器（auxiliary constructor）
- 嵌套类
- Any 类
- case class

## Chapter 06 object【单例对象与伴生对象】

- 单例对象（singleton object）
- 伴生对象/类（companion object/class）
- 扩展类或特质的对象
- 对象中的 apply 方法
- 应用程序入口（main方法）
- 枚举

## Chapter 07 package and import【包和引入】

- package
- 作用域规则
- 串联式包语句
- 文件顶部标记法
- 包对象
- 包可见性
- import
- 任何地方都可以引入包
- 重命名和隐藏方法
- 隐式引入

## Chapter 08 extends

- 扩展类
- 重写方法
- 类型检查和转换
- 受保护的字段和方法
- 父类的构造
- 重写字段
- 匿名子类
- 抽象类
- 抽象字段
- 构造顺序和提前定义
- 类的继承层级
- 对象相等性

## Chapter 09 文件和正则表达式

- 从文件读取数据
- 读取字符
- 读取词法单元和数字
- 从 URL 或者其他来源读取数据
- 读取二进制文件
- 写入文本文件
- 访问目录
- 序列化
- 进程控制
- 正则表达式
- 正则表达式组

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
- 特质构造顺序
- 初始化特质中的字段
- 扩展类的特质
- 自身类型
- 背后发生了什么
- Iterable 特质

## Chapter 11 操作符

- 标识符
- 中置操作符（二元操作符）
- 一元操作符
- 赋值操作符
- 操作符优先级
- 操作符结合性
- apply 和 update 方法
- unapply 提取器
- unapplySeq 方法

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
- 偏函数（PartialFunction）

## Chapter 13 Collection（集合）

- 主要的集合特质
- scala.collection.Iterable 特质
- scala.collection.Seq 特质
- scala.collection.Set 特质
- scala.collection.Map 特质
- 懒视图

## Chapter 14 模式匹配和样例类

- match case 表达式
- match case 表达式中的守卫
- match case 表达式中的变量
- match case 匹配类型
- 匹配 Array、List、Tuple 类型
- 提取器
- 变量声明中的模式
- 循环语句 for 表达式中的模式
- case 语句中的中置表达法// TODO
- 匹配嵌套结构
- 样例类是邪恶的吗？
- 密封类
- 模拟枚举类型

## Chapter 15 注解

- 什么是注解？
- 什么可以被注解？
- 注解参数
- 创建注解【TODO】
- 针对Java特性的注解【TODO】
- 用于优化的注解【TODO】
- 用于错误和警告的注解【TODO】

## Chapter 16 XML 处理

- Scala 提供了对 XML 的默认支持，我们从 2.13.1 开始学习，目前已经不在默认类库里面，待学习。

## Chapter 17 类型参数

- 泛型类【使用类型参数(Type parameter)的类】
- 泛型函数【使用类型参数(Type parameter)的函数和方法】
- 类型参数的上下界定
- 视图界定【View bounds】2.12.0 以后过期
- 上下文界定
- Manifest 上下文界定
- 多重界定
- 类型约束
- 协变
- 逆变
- 协变和逆变点
- 对象不能泛型
- 类型通配符

## Chapter 18 高级类型

- 单例类型
- 类型投影
- 路径
- 类型别名
- 结构类型
- 复合类型
- 中置类型
- 存在类型

## Chapter 19 解析

- // TODO，先不看这

## Chapter 20 Actor

- 1 创建和启动 Actor
- 2 发送消息到 Actor
- 3 取出 Actor 收到的消息
- 4 向其他 Actor 发送消息
- 5 消息通道【TODO】310页
- 6 同步消息和Future【TODO】311页

## Chapter 21 隐式转换和隐式参数

## Chapter 22 定界延续

## Chapter 23 util 类库

- scala.util.Random
- scala.util.Properties
- scala.util.{Try, Success, Failure}
- scala.util.Either
- scala.util.control.Breaks

## Chapter 24 math 类库

## Chapter 25 sys 类库

## Chapter 26 io 类库

- scala.sys.process._

