package cn.duchaoqun.Chapter21

/**
  * 21.1 隐式转换
  *
  * 1. 隐式转换用于在类型之间做转换。
  * 2. 你必须引入隐式转换，并确保他们可以以单个标识符的形式出现在当前作用域。
  * 3. 隐式参数列表会要求指定类型的对象，他们可以从当前作用域中以单个标识符定义的隐式对象获取，或者从目标类型的伴生对象获取。
  * 4. 如果隐式参数是一个单参数的函数，那么它同时也会被作为隐式转换使用。
  * 5. 类型参数的上下文界定要求存在一个指定类型的隐式对象。
  * 6. 如果有可能定位到一个隐式对象，这一点可以作为证据证明某个类型转换是合法的。
  * 7. 你可以给隐式转换函数起任何一个名字，但是使用约定的 source2Target 这样的约定是最好的。
  * 8. 在我们使用第三方jar包的时候，有些时候会发现如果它包含一些方法可能会更好用，这里我们就用implicit来扩展它的类的功能（添加我们自己的method）。
  * 1. scala会默认帮我们import scala.Predef，Predef Object中定义了一些常用的隐式转换method。
  *
  *
  * 通常发生隐式转换的地方：
  * - 当我们使用一个类型的时候，如果该类型无法直接找到合适的方法，则会到其伴生对象中查找隐式功能。
  * - 如果当前类的伴生对象无法找到相关的功能，则会到该类相关的所有类和接口的伴生对象去查找。(父类, 父类的伴生对象)
  * - method 中输入的参数类型与实际类型不一致，此时会尝试寻找隐式转换。
  * - 如果不使用转换就能编译通过（有些地方是scala的类型自动推断的），不会发生隐式转换。
  * - 如果隐式转换存在二义性，即当前上下文中定义了相同功能的隐式转换method，不会发生隐式转换(实际编译报错)。
  *
  * 其他：
  * 寻找隐式转换方法首先会在当前作用域中寻找，IDEA 会有下划线提示，说明调用了隐式转换方法。
  *
  *
  * 注意：
  * 如果当前作用域中有两个相同类型的隐式值会提示错误，发现冲突。
  * 如果太过于频繁地使用implicit，代码可读性就会很低，所以在使用隐式转换之前，先看一看能否用其他方式例如继承、重载来实现。
  *
  */
object Demo21 {}