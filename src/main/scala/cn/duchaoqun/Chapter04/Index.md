## Chapter 04 Map and Tuple【映射和元组】

### 【Demo01】创建 Map 对象

- Map 是键值对的集合。

### 【Demo02】获取 Map 中的值

### 【Demo03】更新 Map 中的值

- 在可变映射中，你可以更新某个Map的值，或者添加一个新的Map

### 【Demo04】迭代 Map

### 【Demo05】树形 Map

- 默认情况下 Scala 提供的是哈希表，由于对使用的键没有很好的哈希函数，或者需要顺序的访问所有的键，可能会需要一个。
- scala.collection.mutable.SortedMap（树形映射）
- scala.collection.immutable.SortedMap（树形映射）
- scala.collection.mutable.LinkedHashMap

### 【Demo07】Tuple

- Tuple 是 n 个对象的集合，Map 可以看作是一个二元组，也就是 Tuple2 类型。
- Tuple 是不可变的，但与列表不同的是 Tuple 可以包含不同类型的元素（该元组的类型由其保存的内容决定）。
- Tuple 中最多只能包含 22 个元素，目前 scala 根包中有tuple1 -> tuple22。
- Tuple 的下标是从 1 开始的。
- 重要的作用之一就是用作函数的返回值，在Tuple中返回若干值。

### 【Demo08】zip【拉链操作】

- 如果你有一个键的集合，以及与它平行对于的值的集合，那么你就可以使用拉链操作来将他们组合成一个映射。keys.zip(values).toMap