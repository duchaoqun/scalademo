package cn.duchaoqun.Chapter06

import java.net.URL

/**
  * 6.4 apply方法
  * 通常使用一个伴生对象的 apply 方法创建伴生类的对象。
  */
object Demo4 extends App {

  val arr1 = Array(1,2,3,4,5) // 这个Array就是调用的apply方法（在使用嵌套表达式的时候这样很方便）

  // 注意Array(100) 和 new Array(100)是完全不一样的， 前一个只有一个元素100，后一个包含100个null元素。

  //执行TagA(html,uRL) 的初始化过程
  val html = "<html>"
  val a = TagA(html)  //第一步 使用Object的apply方法创建对象  最后一步, 完成对象创建和赋值.
}


// TODO: 初始化顺序
class TagA(html: String) {                 // 第六步, 执行主构造函数,
  private var tagA = ""                    // 第七步, 初始化属性
  private var href = ""                    // 第八步, 初始化属性
  private var url = new URL("https://www.duchaoqun.cn")  // 第九步, 初始化属性
  private var host = url.getHost       // 第十步, 初始化属性!!!!!!!!!!!!!!!!!! 这里就是错误的, 此时我们传过来的uRL并没有使用到(对于属性的操作应该写在方法里面,在对象创建完毕后调用.).


  def this(html: String, url: URL) {  // 第四步, 跳转到辅助构造函数.
    this(html)                         // 第五步, 跳转到主构造函数,
    this.url = url                    // 倒数第二步, 完成赋值.
  }
}

object TagA {
  // 定义 apply 方法
  def apply(html: String): TagA = new TagA(html)
  // 定义 apply 方法
  def apply(html: String, uRL: URL): TagA = {   // 第二步, 跳转到这里
    new TagA(html, uRL)                         // 第三步, 在这里创建对象
  }
}