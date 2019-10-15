## Chapter 05 class  以及 类型系统

### 【Demo01】简单类和无参方法

- 使用 class 关键字定义一个类，然后使用 new class 的方式创建这个类的对象。
- 类并不用 public 关键字进行修饰，一个Scala源文件中可以包含多个Class，所有这些类都具有共有可见性。

### 【Demo02】"getter" and "setter" 属性

- 在编写 Java 的时候，我们并不喜欢共有字段，因为任何人都可以写入并更改这个字段值。
- 这时我们更倾向于使用 getter/setter 的方式来使用字段，这样的一对通常被称为属性（property）。
- 为什么要定义这样一个属性（拥有getter/setter方法的字段）呢？
  从对象自身来讲，使用共有字段进行修改更为方便，但是不能每个调用者都可以随便使用这个属性。通过定义getter/setter方法，我
  们可以对属性的使用条件进行限制，让我们自己决定取值或改值是否合理。

### 【Demo03】只有 getter 的属性

- 有时候你需要一个只读属性，有 getter 但是没有 setter，如果属性的值在对象创建完成之后就不会再改变，则可以使用 val 关键字。
- 当在 Scala 类中看到一个字段的时候，就应该想到它是一个私有字段，且携带了 getter(val修饰)方法，或者 getter/setter(var修饰)方法。

### 【Demo04】对象私有字段

- 方法可以访问该类的所有对象的私有字段。

### 【Demo05】Bean 属性

- 上面所述 Scala 默认给字段提供了 getter/setter 方法，但是这个不符合 JavaBean 规范，这些名称不是 Java 工具所期望的。
- 这里我们使用 @BeanProperty 注解实现符合 JavaBean 规范的代码。

- 6 主构造器
- 7 辅助构造器
- 8 嵌套类
- 9 Any 类

## case class 【样例类】

- 【Demo10】样例类是一种特殊的类，它们经过优化被用于模式匹配。
- 【Demo11】样例类的 copy 方法和带名参数。