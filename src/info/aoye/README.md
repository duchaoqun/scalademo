# Scala 练习代码

《快学Scala》一书中的内容，第一张忽略，从第二章开始记录笔记。

## Chapter 2 控制结构和函数

- 2.1 条件表达式
- 2.2 语句终止
- 2.3 块表达式和赋值
- 2.4 输入和输出
- 2.5 循环
- 2.6 高级for循环和for推导式
- 2.7 函数（function）
- 2.8 默认参数和带名参数
- 2.9 变长参数
- 2.10 过程（procedure）
- 2.11 懒值
- 2.12 异常

## Chapter 3 数组相关操作

重点：
1. 若长度固定则使用Array，若长度可能有变化则使用ArrayBuffer.
2. 提供初始值的时候不要使用new
3. 使用()来访问元素
4. 使用for(elem<-arr)来遍历元素
5. 使用for(elem<-arr if ...) ... yield .. 将原来的数组转型为新数组。
6. Scala数组和Java数组可以互操作；用ArrayBuffer，使用scala.collection.JavaConversions中的转换函数。

- 3.1 定长数组
- 3.2 变长数组：数组缓冲
- 3.3 遍历数组Array和缓冲数组ArrayBuffer
- 3.4 数组转换
- 3.5 常用算法
- 3.6 解读ScalaDoc ? TraversableOnce特质
- 3.7 多维数组
- 3.8 Scala与Java的互操作

## Chapter 4 Map 和 Tuple

重点：
1. Map分为可变和不可变
2. Tuple可以用来收集数据

- 4.1 定义Map
- 4.2 获取Map中的值
- 4.3 更新Map中的值
- 4.4 迭代Map
- 4.5 SortedMap(树形映射)
- 4.6 Scala与Java的互操作
- 4.7 Tuple
- 4.8 拉链操作

## Chapter 5 Class

重点：
1. Class中的字段自动带有getter和setter方法
2. 你可以用定制的getter/setter方法替换掉字段的定义，而不必修改使用类的客户端（所谓的同意访问原则）
3. 用@beanProperty注解来生成JavaBeans的getXxx/setXxx方法。
4. 每个类都有一个主要的构造器，这个构造器和类定义“交织”在一起，它的参数直接成为类的字段。主构造器执行类体中的所有语句。
5. 辅助构造器是可选的，它们叫做this

- 5.1 简单类和无参方法
- 5.2 带getter和setter的属性
- 5.3 只有getter的属性
- 5.4 对象私有字段
- 5.5 Bean属性【L1】
