## Chapter 12 Method and Procedure and Function（方法、过程、函数）

### 关于方法

- 在OOP中，方法作用于对象，是对象的行为，Java中的方法这样的，在Scala中的方法也是如此。
- 方法是一个以 def 关键字声明的带有参数列表（可以没有参数列表，参数列表也可以为空）的一个逻辑操作块，例如 object 或 class 中的成员方法。
- 方法不能被直接传递，它属于对象。
- 方法可以被转换成函数。
- 定义方法的基本格式：def methodName(参数: 参数类型, 参数: 参数类型): 返回值类型 = {方法体}

### 关于过程

- 如果方法的结果类型是 Unit，执行它的目的就是为了它的副作用（改变方法外的字段状态）就可以去掉结果类型和等号。
- Scala 对不返回值的方法有特殊的表示法，如果函数体包含在花括号当中，但括号没有前面的 = 号，那么返回类型就是 Unit，这样的方法被称为过程procedure，procedure不返回值，调用它仅仅是为了他的副作用。
- 如果去掉方法体前面的等号，那么该方法的结果类型就必定是 Unit，如果方法的返回类型是String，但是结果类型被说明为Unit，那么String将被转换成Unit并丢弃原来的值

### 关于函数

- 函数可以简单的包裹一条或者几条语句，该代码接受若干参数，经过代码处理后返回结果。型如数学中的 F(x)=x + 1
- 在 Scala 中，函数是一等公民，可以像变量一样被传递，被赋值，同时函数可以赋值给变量。变量也可以赋值给函数，之所以会这样，原因是因为函数背后是一个对象，也就是说这个函数其实是一个变量（是 Scala 帮助我们自动生成的）
- 不依赖于类的用 def 关键字定义的就是函数，依赖于类的叫做方法，没有返回值的叫做过程。
- 函数会自动进行类型推断，来推断函数的返回值类型。注意：必须给出所有参数的类型，如果函数体不是递归的，那么我们不需要定义返回值类型，编译器会自动推断。
- 如果函数名称和函数体之间没有等号，那么该函数的返回值类型会推断失败(不是函数体最后一条语句的结果类型)，这个函数的结果类型是Unit。
- 如果在函数体中，无法推倒出具体的结果类型，则必须声明结果类型。
- 函数的参数可以有默认值，这样在调用函数的时候，如果不想改变默认值的话，这样就不传递该参数，直接使用默认值。这在编程过程中中意义重大，这在Spark编程中非常有用，因为框架一般有自己的默认配置和实现。
- 我们可以基于函数的参数的名称，来调整函数的传递参数的顺序。  重点在于为什么可以这么做呢？原因在于函数背后就是类! 其参数就是类的成员，所以无所谓顺序。
- 可变参数中的数据其实被收集成为 Array 数组，例如 main 的 args 就是Array[String] 的方式来实现的。
- 定义函数的基本格式：val functionName: Int => Int = (x: Int, y: Int) => x + y
  
### 一些区别

- 方法一般块代码较长，可以改变对象自身状态。
- 过程可以理解为方法的下属，执行它的目的就是为了它的副作用（改变方法外的字段状态），返回 Unit 类型。
- 函数也可以理解为方法的下属，代码较少，用法更为灵活。
- 调用没有参数的方法的时候，可以省略小括号。调用没有参数的函数的时候，不能省略小括号。
- 如果我们想实现一个方法，但是方法体内容特别少，则可以考虑使用函数来实现。

### 【Demo01】定义方法、过程、函数

- Function 是一个赋值给一个变量（或者常量）的匿名方法（带或者不带参数列表），并且通过 => 转换符号跟上逻辑代码块的一个表达式。
  => 转换符号后面的逻辑代码块的写法与 method 的 body 部分相同。
- Function 是指类型为 ParamsType => ResultType 的变量，这些变量背后是用 FunctionN 对象来封装的，可以被传递。
- Function 必须有参数列表（可以为空）。
- 调用没有参数的 Function 的时候，留意携带的小括号！


### 【Demo02】有参数的函数 - 斐波那契数列

### 【Demo04】使用默认参数的函数

- 如果没有使用参数，就会使用默认的参数。
- 可以输入带名的参数来调整参数的输入顺序。

### 【Demo06】可变长的参数

- // TODO：当方法需要多个相同类型的参数时，可以用可变参数简化方法的定义，但是这种方式与直接接收一个Seq类型的变量有多少区别的？  

### 【Demo10】参数“类型”推断

### 【Demo07】使用“函数作为参数”的函数

- 高阶函数都是使用“函数”作为参数的。
- 函数参数的通常命名为：function, func, f

### 【Demo05】函数的结果类型

- Scala 默认使用方法的最后一个表达式的结果作为返回值，个别时候可以省略方法的返回值类型，但是如果手动指定了 return 内容，就必须声明方法的返回值类型。
- 如果函数名称和函数体之间没有等号，那么该函数的返回值类型会推断失败(不是函数体最后一条语句的结果类型)，这个函数的结果类型是 Unit，这个函数就是过程

### 【Demo08】将函数赋值给 val 变量
### 【Demo09】使用匿名函数
### 【Demo23】高阶函数 collect
### 【Demo16】高阶函数 filter
### 【Demo18】高阶函数 flatMap
### 【Demo21】高阶函数 foldLeft
### 【Demo22】高阶函数 foldRight
### 【Demo15】高阶函数 foreach
### 【Demo11】高阶函数 map
### 【Demo19】高阶函数 reduce
### 【Demo17】高阶函数 reduceLeft
### 【Demo20】高阶函数 reduceRight
### 【TODO】高阶函数 sortWith

### 【Demo12】闭包【TODO】
### 【Demo13】柯里化

- 柯里化（Currying）：是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术

### 副作用（side effect）

- 副作用是函数式编程语言的一个说法，指的是破坏函数的“纯函数性”（或者说“无副作用性”）。
- 纯函数，纯函数就是指给定相同输入就一定会有相同输出的函数。
- 从实现上来说这样的函数没有为自己保留生命周期超过自身调用的上下文，例如C语言里函数中的static变量的生命周期就会比函数调用要长。
  比如像sin()、cos()这样的函数就是纯函数的，给定相同的输入就一定会有相同的输出。
  当然还有一类函数自身具有一定的状态，导致即便你给定相同的输入，也不一定会给出相同的输出。
  比如常见的随机函数rand()就是这一类。这一类函数内部保存的状态破坏了其函数的“纯度”，所以就被称为具有副作用。

- 纯函数和带有副作用的函数并非是不可转换的，只要将非纯函数的状态提取成一个context并在调用时传给函数，就能将函数改造为纯函数，比如同是随机函数的rand_r()就是个纯函数。
- 之所以提倡编写纯函数尽量避免副作用，是因为具有副作用的函数的状态其实类似于一个单例（无论多少次被调用，访问的都是同一个上下文），从而给函数的并发带来麻烦。
- 除开并发上的缺点，带有副作用的函数也通常没有纯函数好调试。

## TODO

- SAM转换【快学Scala 书中12.7】
- 控制抽象【TODO】
- return 表达式【TODO】