package cn.duchaoqun.Chapter18

object Demo01 extends App {

  // 给定任何引用 v ，你可以得到类型 v.type，它可能有两个值： v 和 null。
  // 这看上去很古怪，但它在有些时候很有用。

  // 首先我们来看看那些返回 this 的方法，通过这种方法你可以把方法调用串接起来：

  class Document {
    def setTitle(title: String): Document = {
      this
    }

    def setTitle1(title: String): this.type = {
      this
    }

    def setAuthor(author: String): Document = {
      this
    }
  }

  val doc1 = new Document
  // 然后你就可以编写如下串接起来的代码了。
  doc1.setTitle("Scala").setAuthor("Scala")

  // 不过，要是你还有子类，问题就来了：
  class Book extends Document {
    def addChapter(chapter: String): Book = {
      this
    }
  }

  // 由于 setTitle 返回的是 this，Scala 将返回类型推断为 Document，但是 Document 没有 addChapter方法。
  // 解决方法是声明 setTitle 的返回类型是 this.type
  val book1 = new Book
  // book1.setTitle("Scala").addChapter("Chapter1") // 这里发生错误。

  // 这里调用 setTitle 返回的类型就是 book.type ，然后就可以串接调用了。
  book1.setTitle1("Scala").addChapter("Chapter1")


  // 如果你想要定义一个接受 object 实例作为参数的方法，你也可以使用单例类型。
  // 你可能会纳闷，什么时候才会这样做呢？毕竟只有一个实例，方法直接用它就好了，为什么还要调用者将它传入呢？

  // 有些人喜欢构造那种读起来像英文的“流利接口”
  // book1 set Title to "Scala for the Impatient"
  // 上面代码被解析成
  // book1.set(Title).to("Scala for the Impatient")
  // 要让这段代码工作， set 需要时一个参数为单例 Title 的方法。

  object Title

  class Document1 {
    private var useNextArgAs: Any = null

    def det(obj: Title.type): this.type = {
      useNextArgAs = obj
      this
    }

    //def to(arg: String) = if (useNextArgAs == Title) {title = arg}
  }
  // 注意 Title.type 参数，你不能用 def set(obj: Title) ... // 错误
  // 因为 Title 指代的是单例对象，而不是类型。

}
