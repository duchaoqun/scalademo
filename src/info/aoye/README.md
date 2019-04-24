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