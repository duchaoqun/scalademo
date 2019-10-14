## Chapter 13 Collection（集合）

- Array 是一个非常基础的数据结构，不从属于 Scala 集合的体系。
- Scala 的集合体系中, 集合分为可变集合和不可变集合之分。
- 不可变集合在scala.collection.immutable包中。
- 可变几何在scala.collection.mutable包中。

- 13.1 主要的集合特质
- 13.2 可变和不可变集合
- 13.3 Seq(序列)
- 13.4 List(不可变列表)
- 13.5 ListBuffer(可变列表)

### 【Demo06】scala.collection.immutable.Set

- Set 适合存无序非重复数据，进行快速查找海量元素的等场景。
- 和 List 不同， Set 并不保存元素的插入顺序。
- scala.collection.mutable.Set
- scala.collection.mutable.HashSet

### 【Demo07】scala.collection.mutable.Set

- 同上，mutable.Set在添加元素的时候返回的是对象本身。

- 13.7 用于添加或删除元素的操作符【TODO】
- 13.8 常用方法
- 13.9 将函数映射到集合
- 13.10 化简，折叠，扫描
- 13.11 拉链操作
- 13.12 迭代器
- 13.13 流
- 13.14 懒视图
- 13.15 与Java集合的互操作
- 13.16 线程安全的集合
- 13.17 并行集合

### 【Demo14】scala.collection.immutable.Queue
### 【Demo19】scala.collection.mutable.Queue
### 【Demo15】Vector

### 【Demo16】scala.collection.mutable.HashMap
### 【Demo17】scala.collection.mutable.HashSet
### 【Demo18】scala.collection.mutable.LinkedHashSet

### 【Demo20】scala.collection.mutable.Seq
### 【Demo21】scala.collection.mutable.SortedSet
### 【Demo22】scala.collection.mutable.Stack
### 【Demo23】scala.collection.mutable.StringBuilder
