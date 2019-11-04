## Chapter 05 class  以及 类型系统

## 类型系统

- Any 最顶层
  - AnyVal
    - Double 数值类型
    - Float  数值类型
    - Long   数值类型
    - Int    数值类型
    - Short  数值类型
    - Byte   数值类型
    - Char   数值类型
    - Boolean
    - Unit
  - AnyRef
- Nothing
- Null

- Scala 2.10之前，AnyVal是一个密封的trait，不能被继承。
- Scala 2.10开始，我们可以自定义一个从AnyVal继承下来的类型。
- 类 Null 代表 null 引用，它是所有引用类（每个由AnyRef派生的类）的子类。
- Null 和值类型不兼容，也就是比如说，你不能把 null 赋值给一个整数类型变量。
- 包含了Java的Object类的一些方法，比如notify()、wait()和finalize()，AnyRef是可以直接当做java的Object来用的。
- 对于Any和AnyVal，只有在编译的时候，scala才会将它们视为Object。换句话说，在编译阶段Any和AnyVal会被类型擦除为Object。

### 【Demo09】Any 类

- Scala 类继承结构中最顶层的，所有运行环境中的 Scala 类都是直接或间接继承自 Any 这个类，所有类的父类。

### 【Demo12】Nothing 类

- scala.Nothing，为底层类型，所有类的最终子类都是Nothing。
- 然而这个类型没有任何实例（也就是没有任何值对应Nothing类型），Nothing 类型的一个用法是示意应用程序非正常终止，比如 Predef 的有一个 error 方法。

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

### 【Demo06】主构造器（primary constructor）

- 每个类都有一个主要的构造器，这个构造器和类定义“交织”在一起，主构造器执行类体中的所有语句。
- 主构造器直接放置在类名之后，此时在apply的方法中也必须有这些参数。
- 主构造器的参数被编译成类的属性，被初始化为传入的参数值。
- 主构造器里面的变量是私有的。
    
### 【Demo07】辅助构造器（auxiliary constructor）

- 类可以有多个辅助构造器。
- 辅助构造器是可选的，名称都为 this ，在修改类名时无需更改构造器名字。
- 每一个辅助构造器必须一个对先前已经定义的其他辅助构造器或者主构造器的调用开始。

### 【Demo08】嵌套类

- 在 Scala 中你可以在任意的语法结构中嵌套任意的语法结构，你可以在函数中定义函数，在类中定义类。
- 在 Scala 中每个实例都有它自己的 Member 类，就像属性一样，两个不同的对象包含的 Member 类是不相同的。
  
## case class 【样例类】

- 【Demo10】样例类是一种特殊的类，它们经过优化被用于模式匹配。
- 【Demo11】样例类的 copy 方法和带名参数。

## 【Demo13】classOf 和 getClass

- 类(class)与类型(type)是两个不一样的概念。
- 在java里因为早期一直使用class表达type，并且现在也延续这样的习惯。
- 类型(type)比类(class)更“具体”，任何数据都有类型。
- 类是面向对象系统里对同一类数据的抽象，在没有泛型之前，类型系统不存在高阶概念，直接与类一一映射，而泛型出现之后，就不在一一映射了。
- 比如定义class List[T]{}, 可以有List[Int] 和 List[String]等具体类型，它们的类是同一个List，但类型则根据不同的构造参数类型而不同。
- 类型一致的对象它们的类也是一致的，反过来，类一致的，其对象的类型不一定一致。

## 【Demo14】ClassTag 和 TypeTag

- ClassTag[T] 保存了被泛型擦除后的原始类型 T，提供给运行时。
- TypeTag 则保存所有具体的类型。