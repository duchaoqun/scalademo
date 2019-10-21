## Chapter 14 模式匹配和样例类

### 【Demo01】match case 表达式

- 一个模式匹配包含了一系列备选项，每个都开始于关键字 case。每个备选项都包含了一个模式及一到多个表达式。箭头符号 => 隔开了模式和表达式。
- case _ 默认匹配，如果没找到匹配的内容，就执行这部分代码（避免匹配不到而报MatchError）。
- 与 if 表达式类似，match 也是表达式，而不是语句
- 你可以在 match 表达式中使用任何类型，而不仅仅是数字

### 【Demo02】match case 表达式中的守卫

### 【Demo03】match case 表达式中的变量

### 【Demo04】match case 匹配类型

- 在 Scala 中，我们更倾向去使用这种 match case 语句，而不是 isInstanceOf 操作符。

### 【Demo05】匹配 Array、List、Tuple 类型

### 【Demo06】提取器

- 模式匹配可以匹配 array、list、tuple 等各种类型，其背后的机制就是提取器（extractor）。

### 【Demo07】变量声明中的模式

### 【Demo08】循环语句 for 表达式中的模式

### 【Demo09】case 语句中的中置表达法// TODO

### 【Demo10】匹配嵌套结构

### 样例类是邪恶的吗？

- 既有有点也有缺点。
- 模式匹配通常比继承更容易把我们引向更精简的代码。
- 构造时不需要用 new 的复合对象更加易读。
- 我们会自动获取 toString、equals、hashCode、copy 方法。

### 【Demo11】密封类

- 当你用样例类来做模式匹配的时候，你可能想让编译器帮你确保已经列出了所有可能的选择，要达到这个目的，你需要将样例类的通用父类声名为 sealed。

### 【Demo12】模拟枚举类型

- 样例类可以让你在 Scala 中模拟出枚举类型。