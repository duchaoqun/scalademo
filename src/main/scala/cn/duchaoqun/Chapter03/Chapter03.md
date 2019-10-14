## Chapter 03 Array【数组】

- Scala会默认添加对Array包的引用。
- Array对象本身在底层实是不可变的!!! 虽然元素不能删减! 但是我们可以修改元素的内容!!!
- 如果我们想使用可变数组的话，首先需要导入scala.collection.mutable.ArrayBuffer，然后使用 ArrayBuffer 这个可变数组。
- 关于ArrayBuffer增加元素，默认都是在末尾增加元素的，所以效率非常高。

### 【Demo01】Array（定长数组，不可变）

- 如果你需要一个长度不变的数组，可以使用Scala中的Array，必须声明类型(泛型)。

### 【Demo02】变长数组（ArrayBuffer）

- 对于那种长度需要变化的数组，Java 有 ArrayList，C++ 有vector，Scala 中等效的数据结构是 ArrayBuffer。

### 【Demo03】遍历数组 Array 和 ArrayBuffer

### 【Demo04】数组转换

- 从一个数组或者缓冲数组出发，以某种方式对他进行转换，产生一个新的数组（不会改变原来数组）。

### 【Demo05】常用方法

### 【Demo06】解读ScalaDoc ? TraversableOnce特质

- 查询API可以让我们使用很多有意思的方法，官方已经为我们写好了很多功能。

### 【Demo07】多维数组

- 通过数组的数组来实现

### 【Demo08】Scala 与 Java 的互操作