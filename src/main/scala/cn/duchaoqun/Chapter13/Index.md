## Chapter 13 Collection（集合）

- Array 是一个非常基础的数据结构，不从属于 Scala 集合的体系。
- Scala 的集合体系中, 集合分为可变集合和不可变集合之分。
- 不可变集合在scala.collection.immutable包中。
- 可变几何在scala.collection.mutable包中。
- 对不可变的集合进行操作，一般返回的是一个新的集合，对可变的集合进行操作，返回的是该对象本身。
- 【Demo02】不可变集合从来不会被改变，你可以安全的共享其引用，甚至在一个多线程的程序中使用都没有问题。
- 可以将函数传递给集合的高阶函数，参考 Chapter 12 中各个高阶函数的用法。

### 【Demo01】主要的集合特质

如下是集合的基本继承层级关系，最上层是 Iterable 特质

Iterable[Trait]
Seq[Trait]          Set[Trait]          Map[Trait]
IndexedSeq[Trait]   SortedSet[Trait]    SortedMap[Trait]

- Iterable 指的是那些能生成用来访问集合中所有元素的 Iterator 的集合：
- Seq 是一个有“先后次序”的值的序列，比如数组或列表，IndexedSeq 允许我们通过整型的下标快速的访问任意元素，例如 ArrayBuffer 是带下标的，但链表不是。
- Set 是一组没有“先后次序”的值。在SortedSet中，元素可以以某种排过序的顺序被访问。
- Map 是一组对偶。SortedMap 按照键的排序访问其中的元素。
- 每个 Scala 集合特质或者类都有一个带有 apply 方法的伴生对象，这个方法可以用来创建该集合的实例。【统一创建原则】

### 【Demo07】scala.collection.Iterable 特质

- Iterable 特质集合类型继承层次中最上层的特质。
- Scala Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法。

### 【Demo03】scala.collection.Seq 特质

如下是常用的不可变序列：
Seq[trait]
IndexedSeq[trait]        List         Stream     Stack    Queue
Vector      Range

如下是常用的可变的序列：
Seq[trait]
IndexedSeq[trait]   Stack  Queue  PriorityQueue  ListBuffer  DoubleLinkedList
ArrayBuffer

- Vector 是 ArrayBuffer 的不可变版本： 一个带下标的序列，支持快速的随机访问。
- Vector 是以树形结构的形式实现的，每个节点可以有不超过 32 个子节点。对于一个有 100 万个元素的向量来说，我们只需要四层节点。访问这样一个列表中的某个元素只需要 4 跳，而在链表中，同样的操作需要 500000跳。
- Range 表示一个整数数列，比如 “0、1、2、3、4、5” 和 “10、20、30”，Range 对象并不存储所有的值，它仅存储“开始、结束、增值”。
- 可以使用 to 和 until 来创建 Range 对象。
- Seq 特质中常见的方法：contains containsSlice starsWith endsWith indesOf... // TODO


### 【Demo04】List(不可变列表)

- 不可变列表的值是不可变的，个别时候只是取了原来列表的值返回新创建的一个列表。
- 在Scala中，列表只有两种形态，一种只是一个 Nil 空列表。另外一种是一个 head 元素，和一个 tail 列表。（tail 列表也是这么组成的，直到 tail 是 Nil）

### 【Demo05】ListBuffer(可变列表)

- 2.11.0 以前的版本使用 LinkedList ，和不可变的 List 类似，只不过你可以通过 elem 引用来修改其头部，next 引用来修改其尾部。
- 2.13.0 使用 ListBuffer。

### 【Demo08】scala.collection.Set 特质

- Set 适合存无序非重复数据，进行快速查找海量元素的等场景（默认情况是用HasSet实现的）。
- Set 和 List 不同，并不保存元素的插入顺序。
- LinkedHashSet 可以记住元素被插入的顺序，它会维护一个链表来达到这个目的。
- SortedSet 是用红黑树实现的。
- BitSet 是 Set 的一种实现，以一个字位序列的方式存放非负整数，如果 Set 中有 i，则第 i 个字位是1。
- 【Demo06】scala.collection.immutable.Set
- scala.collection.immutable.BitSet
- 【Demo07】scala.collection.mutable.Set
- 【Demo17】scala.collection.mutable.HashSet
- 【Demo18】scala.collection.mutable.LinkedHashSet
- 【Demo21】scala.collection.mutable.SortedSet
- scala.collection.mutable.BitSet
- Set 特质特有想一些方法 // TODO

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
### 【Demo20】scala.collection.mutable.Seq
### 【Demo22】scala.collection.mutable.Stack
### 【Demo23】scala.collection.mutable.StringBuilder