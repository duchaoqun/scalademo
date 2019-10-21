## Chapter 13 Collection（集合）

- Array 是一个非常基础的数据结构，不从属于 Scala 集合的体系。
- Scala 的集合体系中, 集合分为可变集合和不可变集合之分，不可变集合在 scala.collection.immutable 包中，可变集合在 scala.collection.mutable 包中。
- 对不可变的集合进行操作，一般返回的是一个新的集合，对可变的集合进行操作，返回的是该对象本身。
- 【Demo02】不可变集合从来不会被改变，你可以安全的共享其引用，甚至在一个多线程的程序中使用都没有问题。
- 可以将函数传递给集合的高阶函数，参考 Chapter 12 中各个高阶函数的用法。
- 每个 Scala 集合特质或者类都有一个带有 apply 方法的伴生对象，这个方法可以用来创建该集合的实例，符合“统一创建原则”。

### 【Demo01】主要的集合特质

如下是集合的基本继承层级关系，最上层是 Iterable 特质

- Iterable[Trait]
  - Seq[trait]
    - IndexedSeq[trait]
      - immutable.Vector
      - immutable.Range
      - mutable.ArrayBuffer 
    - immutable.List
    - immutable.Stream        2.12.0 过期
    - immutable.LazyList      2.13.0
    - immutable.Stack
    - immutable.Queue
    - mutable.Stack
    - mutable.Queue
    - mutable.PriorityQueue
    - mutable.LinkedList      2.11.0 过期
    - mutable.ListBuffer
    - mutable.DoubleLinkedList
  - Set[Trait]
    - SortedSet[Trait]
  - Map[Trait]
    - SortedMap[Trait]

### 【Demo07】scala.collection.Iterable 特质

- Iterable 特质集合类型继承层次中最上层的特质。
- Iterable 能生成用来访问集合中所有元素的 Iterator。
- Scala Iterator（迭代器）不是一个集合，它是一种用于访问集合的方法，你只有在需要的时候才去获取元素，如果你不需要更多元素，则不会付出计算剩余元素的代价。
- Iterator 在迭代一次之后里面就没有内容了。

### 【Demo03】scala.collection.Seq 特质

- 【Demo20】scala.collection.mutable.Seq
- Seq 是一个有“先后次序”的值的序列，比如数组或列表，IndexedSeq 允许我们通过整型的下标快速的访问任意元素，例如 ArrayBuffer 是带下标的，但链表不是。
- Seq 特质中常见的方法：contains containsSlice starsWith endsWith indexOf... // TODO
- 【Demo15】Vector：是 ArrayBuffer 的不可变版本： 一个带下标的序列，支持快速的随机访问。
- 【Demo15】Vector：是以树形结构的形式实现的，每个节点可以有不超过 32 个子节点。对于一个有 100 万个元素的向量来说，我们只需要四层节点。访问这样一个列表中的某个元素只需要 4 跳，而在链表中，同样的操作需要 500000跳。
- Range 表示一个整数数列，比如 “0、1、2、3、4、5” 和 “10、20、30”，Range 对象并不存储所有的值，它仅存储“开始、结束、增值”。
- Range 对象可以使用 to 和 until 来创建。
- 【Demo04】List：不可变列表的值是不可变的，个别时候只是取了原来列表的值返回新创建的一个列表。
- 【Demo04】List：在 Scala 中，列表只有两种形态，一种只是一个 Nil 空列表。另外一种是一个 head 元素，和一个 tail 列表。（tail 列表也是这么组成的，直到 tail 是 Nil）
- 【Demo09】Stream：过期，是一个尾部被懒计算的不可变列表，只有当你需要时它才会被计算。
- 【Demo05】ListBuffer：和不可变的 List 类似，只不过你可以通过 elem 引用来修改其头部，next 引用来修改其尾部。
- 【Demo14】scala.collection.immutable.Queue
- 【Demo19】scala.collection.mutable.Queue
- 【Demo22】scala.collection.mutable.Stack

### 【Demo08】scala.collection.Set 特质

- Set 是一组没有“先后次序”的值。在SortedSet中，元素可以以某种排过序的顺序被访问。
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

### 【Demo10】scala.collection.Map 特质

- Map 是一组对偶。SortedMap 按照键的排序访问其中的元素。
- 【Demo16】scala.collection.mutable.HashMap


### 【Demo24】懒视图

- 仅当结果被需要的时候才执行计算。
- 你可以对集合使用 view 方法来获得懒视图。

- 【Demo23】scala.collection.mutable.StringBuilder