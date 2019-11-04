
### 不要使用 "return"

Java中的return语句表示一个副作用，展开堆栈并将这个值给调用者。
在一种强调副作用编程的语言中，这是有意义的。
然而Scala是一种面向表达式的语言，它的重点是控制/限制副作用，而“return”不是习惯用法。

更糟糕的是，“return”行为可能跟你脑子里面想的不一样。
例如在PlayFrameword框架里面，写如下代码：

```scala
def action = Action { request =>
  if (someInvalidationOf(request))
    return BadRequest("bad")
 Ok("all ok")
}
```

在Scala中，return是通过NonLocalReturnException来实现的，这部分需要深入学习。
如果代码中包含了return，通常你就需要重构你的代码了。

[参考1](https://www.jianshu.com/p/2053634328d3)
[参考2](https://www.zhihu.com/question/22240354/answer/64673094)
[Scala Language Specification, section 6.20](http://www.scala-lang.org/docu/files/ScalaReference.pdf)

### 使用不可变的数据结构

永远不要使用可变数据结构。

举例说明:

```scala
trait Producer[T] {
 def fetchList: List[T]
}

// consumer side
someProducer.fetchList
```

问题：如果上面trait里面的fetchList返回的List是可变的，那这个Producer是什么意思呢？怎么理解呢？

这里有一些问题：

1. 如果这个列表是在用户之外的另一个线程上生成的，那么就可能同时存在可见性和原子性问题——除非查看生产者的实现，否则无法知道是否会发生这种情况。

2. 即使这个列表实际上是不可变的(即仍然是可变的，但在向使用者发出信号后不再进行修改)，您也不知道它是否会向其他可能自行修改它的使用者发出信号，因此您无法推断可以对它做什么。

3. 即使这个列表的访问必须同步，问题是——您要同步哪个锁?你确定锁的顺序是正确的吗？锁不可组合。

这就是问题所在——公开可变数据结构的公共API是一件令人讨厌的事情，它会导致比手工内存管理更糟糕的问题。

### 不应该使用循环或者条件更新var变量

这是大多数Java程序员在使用Scala时都会范的错误。

例如：

```scala
var sum = 0
for (elem <- elements) {
  sum += elem.value
}
```

避免这样做，尽量使用可用的操作符来实现，例如`foldLeft`:

```scala
val sum = elements.foldLeft(0)((acc, e) => acc + e.value)
```

尽量使用标准库，表达能力越强，bug就越少。

```scala
val sum = elements.map(_.value).sum
```

本着同样的精神，您不应该用条件更新部分结果。
例如:

```scala
def compute(x) = {
  var result = resultFrom(x)

  if(needToAddTwo) {
    result += 2
  }
  else {
      result += 1
  }

  result
}
```

偏向于函数式和不变性。代码将更易于阅读，更不易出错，因为它使分支更显式，这是一件好事：

```scala
def computeResult(x) = {
  val r = resultFrom(x)
  if (needToAddTwo)
    r + 2
  else
    r + 1
}
```

像你知道的，一旦分支变得太复杂，就像在关于“return”的讨论中所说的那样，这是一个迹象表明**代码有问题**需要重构。

### 不要定义无用的trait

有一种Java最佳实践说法“**编程到接口，而不是实现**”，这种最佳实践已经被崇拜到人们开始在他们的代码中定义完全无用的接口。
一般来说，这条规则是健康的，但它指的是隐藏实现细节的一般工程需求，特别是修改状态(封装)的细节，以及不破坏经常泄漏实现细节的接口声明。

定义特征对于代码的读者来说也是一种负担，因为它标志着对多态性的需要。

例如：

```scala
trait PersonLike {
  def name: String
  def age: Int
}

case class Person(name: String, age: Int) extends PersonLike
```

这段代码的读者可能会得出这样的结论：在某些情况下，需要重写“PersonLike”。
这与事实相差甚远，case类将“Person”完美地描述为一个没有行为的数据结构。换句话说，它描述了数据的形状，如果由于某种未知的原因需要重写这个形状，那么这个特征的定义就很糟糕，因为它强加了数据的形状，这是惟一可以重写的东西。如果您需要多态性，在您的需求演化之后，您总是可以稍后提出特性。

如果您认为您可能需要重写这个源文件(比如在第一次访问时从DB中获取此人的“名称”)，不要这样做!

注意，我并不是在讨论代数数据结构(例如，封闭的特征，表示一组封闭的选择——比如`Option`)。

即使在你认为问题很清楚的情况下，情况也可能并非如此。举个例子:

```scala
trait DBService {
  def getAssets: Future[Seq[(AssetConfig, AssetPersistedState)]]

  def persistFlexValue(flex: FlexValue): Future[Unit]
}
```

这段代码取自真实的代码--我们有一个`DBService`，它可以处理数据库中的查询或持久性。这两个方法实际上是不相关的，所以如果您只需要获取资产，为什么要依赖于需要DB交互的组件中不需要的东西呢?

最近我的代码看起来很像这样:

```scala
final class AssetsObservable
    (f: => Future[Seq[(AssetConfig, AssetPersistedState)]])
  extends Observable[AssetConfigEvent] {

  // ...
}

object AssetsObservable {
  // constructor
  def apply(db: DBService) = new AssetsObservable(db.getAssets)
}
```

看，我不需要模拟整个`DBService`来测试上述内容。

### 不要声明抽象的var成员

在abstract class和trait 中使用var成员是一个非常傻瓜的行为，千万不要这样做。

```scala
trait Foo {
  var value: String
}
```

相反，我们应该将抽象的东西定义为 `def`:

```scala
trait Foo {
  def value: String
}

// 然后就可以被任何东西覆盖
class Bar(val value: String) extends Foo
```

`var`只能被`var`覆盖。
允许自由选择继承的方法是对抽象成员使用`def`。

为什么要对继承自接口的变量施加使用`var`的限制呢？
def是通用的，所以用它代替。

### 2.7. MUST NOT throw exceptions for validations of user input or flow control

Two reasons:

1. it goes against the principles of structured programming as a
   routine ends up having multiple exit points and are thus harder to
   reason about - with the stack unwinding happening being an awful and
   often unpredictable side-effect
2. exceptions aren't documented in the function's signature - Java
   tried fixing this with the checked exceptions concept, which in
   practice was awful as people simply ignored them

Exceptions are useful for only one thing - signaling unexpected errors
(bugs) up the stack, such that a supervisor can catch those errors and
decide to do things, like log the errors, send notifications,
restarting the guilty component, etc...

As an appeal to authority, it's reasonable to reference
[Functional Programming with Scala](http://www.manning.com/bjarnason/),
chapter 4.

### 2.8. MUST NOT catch Throwable when catching Exceptions

Never, never, never do this:

```scala
try {
 something()
} catch {
 case ex: Throwable =>
   blaBla()
}
```

Never catch `Throwable` because we could be talking about extremely
fatal exceptions that should never be caught and that should crash the
process. For example if the JVM throws an out of memory error, even if
you re-throw that exception in that catch clause, it may be too late -
given that the process is out of memory, the garbage collector
probably took over and froze everything, with the process ending in a
zombie unrecoverable state. Which means that an external supervisor
(like Upstart) will not get an opportunity to restart it.

Instead do this:

```scala
import scala.util.control.NonFatal

try {
 something()
} catch {
 case NonFatal(ex) =>
   blaBla()
}
```

### 不要使用`null`

您必须避免使用`null`。
要使用Scala的`Option[T]`。
Null值容易出错，因为编译器无法保护它。

```scala
def hello(name: String) =
  if (name != null)
    println(s"Hello, $name")
  else
    println("Hello, anonymous")
```

首先，你应该这么做:

```scala
def hello(name: Option[String]) = {
  val n = name.getOrElse("anonymous")
  println(s"Hello, $n")
}
```

使用`Option[T]`的意义在于编译器强迫我们必须为它做点什么:

1. 您要么必须立即处理它(例如，通过提供默认值、抛出异常等等)。
2. 或者您可以将结果`option`传回调用栈。

Also remember that `Option` is just like a collection of 0 or 1
elements, so you can use foreach, which is totally idiomatic:

```scala
val name: Option[String] = ???

for (n <- name) {
  // executes only when the name is defined
  println(n)
}
```

Combining multiple options is also easy:

```scala
val name: Option[String] = ???
val age: Option[Int] = ???

for (n <- name; a <- age)
  println(s"Name: $n, age: $a")
```

And since `Option` is seen as an `Iterable` too, you can use `flatMap`
on collections to get rid of `None` values:

```scala
val list = Seq(1,2,3,4,5,6)

list.flatMap(x => Some(x).filter(_ % 2 == 0))
// => 2,4,6
```

### 2.10. MUST NOT use `Option.get`

You might be tempted to do this:

```scala
val someValue: Option[Double] = ???

// ....
val result = someValue.get + 1
```

Don't ever do that, since you're trading a `NullPointerException` for a
`NoSuchElementException` and that defeats the purpose of using
`Option` in the first place.

Alternatives:

1. using `Option.getOrElse`
2. using `Option.fold`
3. using pattern matching and dealing with the `None` branch explicitly
4. not taking the value out of its optional context

As an example for (4), not taking the value out of its context means
this:

```scala
val result = someValue.map(_ + 1)
```

### 不要使用Java的Date和Calendar类，要使用`java.time`(JSR-310)

标准库中的Java日期和日历类很糟糕：
因为：

1. 生成的对象是可变的，这对于表示日期没有意义，而日期应该是一个值(如果必须在所有有字符串的地方使用StringBuffer，您会有什么感觉?)
2. 月份是从0开始的。
3. 特别是Date并不保留时区信息，因此日期值完全没用
4. GMT和UTC没有区别
5. 年份用2位数表示，而不是4位数

在Java8以及以上版本，使用[`java.time`](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html) API
在Java8以下的版本上，使用[`Joda-Time`](http://www.joda.org/joda-time/)他是java.time的祖先。

### 2.12. SHOULD NOT use Any or AnyRef or isInstanceOf / asInstanceOf

Avoid using Any or AnyRef or explicit casting, unless you've got a
really good reason for it. Scala is a language that derives value from
its expressive type system, usage of Any or of typecasting represents
a hole in this expressive type system and the compiler doesn't know
how to help you there. In general, something like this is bad:

```scala
val json: Any = ???

if (json.isInstanceOf[String])
  doSomethingWithString(json.asInstanceOf[String])
else if (json.isInstanceOf[Map])
  doSomethingWithMap(json.asInstanceOf[Map])
else
  ???
```

Often we are using Any when doing deserialization. Instead of working
with Any, think about the generic type you want and the set of
sub-types you need, and come up with an Algebraic Data-Type:

```scala
sealed trait JsValue

case class JsNumber(v: Double) extends JsValue
case class JsBool(v: Boolean) extends JsValue
case class JsString(v: String) extends JsValue
case class JsObject(map: Map[String, JsValue]) extends JsValue
case class JsArray(list: Seq[JsValue]) extends JsValue
case object JsNull extends JsValue
```

Now, instead of operating on Any, we can do pattern matching on
JsValue and the compiler can help us here on missing branches, since
the choice is finite. This will trigger a warning on missing branches:

```scala
val json: JsValue = ???
json match {
  case JsString(v) => doSomethingWithString(v)
  case JsNumber(v) => doSomethingWithNumber(v)
  // ...
}
```

### 2.13. MUST serialize dates as either Unix timestamp, or as ISO 8601

Unix timestamps, provided that we are talking about the number of
seconds or milliseconds since 1970-01-01 00:00:00 UTC (with emphasis
on UTC) are a decent cross-platform serialization format. It does have
the disadvantage that it has limits in what it can express. ISO-8601
is a decent serialization format supported by most libraries.

Avoid anything else and also when storing dates without a timezone
attached (like in MySQL), always express that info in UTC.

### 2.14. MUST NOT use magic values

Although not uncommon in other languages to use "magic" (special)
values like `-1` to signal particular outcomes, in Scala there are a
range of types to make intent clear. `Option`, `Either`, `Try` are
examples. Also, in case you want to express more than a boolean
success or failure, you can always come up with an algebraic data
type.

Don't do this:

```scala
val index = list.find(someTest).getOrElse(-1)
```

### 2.15. SHOULD NOT use "var" as shared state

Avoid using "var" at least when speaking about shared mutable
state. Because if you do have shared state expressed as vars, you'd
better synchronize it and it gets ugly fast. Much better is to avoid
it. In case you really need mutable shared state, use an atomic
reference and store immutable things in it. Also checkout
[Scala-STM](https://nbronson.github.io/scala-stm/).

So instead of something like this:

```scala
class Something {
  private var cache = Map.empty[String, String]
}
```

If you can't really avoid that variable, prefer doing this:

```scala
import java.util.concurrent.atomic._

class Something {
  private val cache =
    new AtomicReference(Map.empty[String, String])
}
```

Yes, it introduces overhead due to the synchronization required, which
in the case of an atomic reference means spin loops. But it will save
you from lots and lots of headaches later. And it's best to avoid
mutation entirely.

### 2.16. Public functions SHOULD have an explicit return type

Prefer this:

```scala
def someFunction(param1: T1, param2: T2): Result = {
  ???
}
```

To this:

```scala
def someFunction(param1: T1, param2: T2) = {
  ???
}
```

Yeah, type inference on the result of a function is great and all, but
for public methods:

1. it's not OK to rely on an IDE or to inspect the implementation in
   order to see the returned type
2. Scala currently infers the most specialized type possible, because
   in Scala the return type on functions is covariant, so you might
   actually get a really ugly type back

For example, what is the returned type of this function:

```scala
def sayHelloRunnable(name: String) = new Runnable {
  def sayIt() = println(s"Hello, $name")
  def run() = sayIt()
}
```

Do you think it's `Runnable`?
Wrong, it's `Runnable{def sayIt(): Unit}`.

As a side-effect, this also increases compilation times, as whenever
`sayHelloRunnable` changes implementation, it also changes the
signature so everything that depends on it must be recompiled.

### 2.17. SHOULD NOT define case classes nested in other classes

It is tempting, but you should almost never define nested case classes
inside another object/class because it messes with Java's
serialization. The reason is that when you serialize a case class it
closes over the "this" pointer and serializes the whole object, which
if you are putting in your App object means for every instance of a
case class you serialize the whole world.

And the thing with case classes specifically is that:

1. one expects a case class to be immutable (a value, a fact) and hence
2. one expects a case class to be easily serializable

Prefer flat hierachies.

### 2.18 MUST NOT include classes, traits and objects inside package objects

Classes, including case classes, traits and objects do not belong
inside package objects. It is unnecessary, confuses the compiler and
is therefore discouraged. For example, refrain from doing the
following:

```scala
package foo

package object bar {
  case object FooBar
}
```

The same effect is achieved if all artifacts are inside a plain package:

```scala
package foo.bar

case object FooBar
```

Package objects should only contain value, method and type alias
definitions, etc.  Scala allows multiple public classes in a single
file, and the convention is to have the first letter of the filename
be lowercase in such cases.

#### Implicit value classes can be defined in a package object

In one rare circumstance, it makes sense to include classes defined directly in a `package object`. The reason for that is that implicit classes need to be nested inside another object/class, you cannot define a top level implicit in Scala. Nesting implicit value classes inside a `package object` also allows us to create a great importing experience for a library, as the single import of the package object will bring in all the necessary implicits.

There is also no way around this, as defining the implicit value class means we cannot effectively define the implicit and the class separately, the whole point is to let the compiler avoid the runtime boxing by generating all the "right code" at compile time, by predicting the runtime boxing. This is the optimal way to achieve a pimp my library pattern performance wise, and we need the entire syntax "in one place".

```scala

package object dsl {
  implicit class DateTimeAugmenter(val date: Datetime) extends AnyVal {
    def yesterday: DateTime = date.plusDays(-1)
  }
}

```

### 2.19 SHOULD use head/tail and init/last decomposition only if they can be done in constant time and memory

Example of head/tail decomposition:

```scala
def recursiveSumList(numbers: List[Int], accumulator: Int): Int =
  numbers match {
    case Nil =>
      accumulator

    case head :: tail =>
      recursiveSumList(tail, accumulator + head)
  }
```

`List` has a special head/tail extractor `::` because `List`s are **made** by always appending an element to the front of the list:

```scala
val numbers = 1 :: 2 :: 3 :: Nil
```

This is the same as:

```scala
val numbers = Nil.::(3).::(2).::(1)
```

For this reason, both `head` and `tail` on a list need only constant time and memory! These operations are `O(1)`.

There is another head/tail extractor called `+:` that works on any `Seq`:

```scala
def recursiveSumSeq(numbers: Seq[Int], accumulator: Int): Int =
  numbers match {
    case Nil =>
      accumulator

    case head +: tail =>
      recursiveSumSeq(tail, accumulator + head)
  }
```

You can find the implementation of `+:` [here](https://github.com/scala/scala/blob/v2.12.4/src/library/scala/collection/SeqExtractors.scala). The problem is that other collections than `List` do not necessarily head/tail-decompose in constant time and memory, e.g. an `Array`:

```scala
val numbers = Array.range(0, 10000000)

recursiveSumSeq(numbers, 0)
```

This is highly inefficient: each `tail` on an `Array` takes `O(n)` time and memory, because every time a new array needs to be created!

Unfortunately, the Scala collections library permits these kinds of inefficient operations. We have to keep an eye out for them.

---

An example for an efficient init/last decomposition is `scala.collection.immutable.Queue`. It is backed by two `List`s and the efficiency of `head`, `tail`, `init` and `last` is *amortized constant* time and memory, as explained in the [Scala collection performance characteristics](http://docs.scala-lang.org/overviews/collections/performance-characteristics.html).

I don't think that init/last decomposition is all that common. In general, it is analogue to head/tail decomposition. The init/last deconstructor for any `Seq` is `:+`.


### 2.20 MUST NOT use `Seq.head`

You might be tempted to this:

```scala
val userList: List[User] = ???

// ....
val firstName = userList.head.firstName
```

Don't ever do this, as this will throw `NoSuchElementException` if the sequence is empty.

Alternatives:

1. using `Seq.headOption` possibly combined with `getOrElse` or pattern matching

    Example:
   
    ```scala
    val firstName = userList.headOption match {
        case Some(user) => user.firstName
        case _ => "Unknown"
      }
    ```

2. using pattern matching with the cons operator `::` if you're dealing with a `List`

    Example:
   
    ```scala
    val firstName = userList match {
     case head :: _ => head.firstName
     case _ => "Unknown"
    }
    ```

3. using `NonEmptyList` if it is required that the list should never be empty. (See [cats](https://typelevel.org/cats/datatypes/nel.html), [scalaz](https://github.com/scalaz/scalaz/blob/series/7.3.x/core/src/main/scala/scalaz/NonEmptyList.scala), ...)

### 2.21 Case classes SHOULD be final

Extending a case class will lead to unexpected behaviour. Observe the following:
```scala
scala> case class Foo(v:Int)
defined class Foo

scala> class Bar(v: Int, val x: Int) extends Foo(v)
defined class Bar

scala> new Bar(1, 1) == new Bar(1, 1)
res25: Boolean = true

scala> new Bar(1, 1) == new Bar(1, 2)
res26: Boolean = true
// ????
scala> new Bar(1,1) == Foo(1)
res27: Boolean = true

scala> class Baz(v: Int) extends Foo(v)
defined class Baz

scala> new Baz(1) == new Bar(1,1)
res29: Boolean = true //???

scala> println (new Bar(1,1))
Foo(1) // ???

scala> new Bar(1,2).copy()
res49: Foo = Foo(1) // ???
```
Credits:[Why case classes should be final](https://stackoverflow.com/a/34562046/3856808)

So by default case classes should always be defined as final.

Example:

```scala
final case class User(name: String, id: Long)
```
