package cn.duchaoqun.Chapter01

/**
  * 字符串 String 是不可变对象，在做相应的操作之后需要定义一个新对象来接收，如果需要使用可变内容，可以先了解 StringBuilder 对象。
  *
  * RichString 序列，它的类型是 Seq[Char]。因为 Predef 包含了从 String 到 RichString 的隐式转换，所以你可以把任何字符串当作 Seq[Char]。
  *
  * 字符串中的字符下标是从 0 开始的，最后一个需要-1 ，留意空格字符，从表面上是看不出来的。
  */
object Demo05 extends App {

  // 创建字符串对象
  val str_0 = "Hello! Scala"
  val str_1: String = "Hello! Scala"

  // 获取字符串长度
  // val strSize = str_0.size // 过期
  val strLength: Int = str_0.length // 当前用法

  // 判断字符串是否为空
  val isEmpty: Boolean = str_0.isEmpty

  // 提取不重复的所有字符
  //val str_2: String = str1.distinct // 过期
  val str_2: String = str_0.toSeq.unwrap

  // 提取 n 个字符
  val str_3: String = str_0.take(2) // 获取最前面的2个字符

  // 提取第 n 个字符
  val char_1: Char = str_0.apply(4) // 获取第4个字符内容
  val char_2: Char = str_0(4) // 获取第4个字符内容，()操作符其实是重载了apply方法，下标是以0开始的， 注意偶尔()会跟隐式参数冲突，所以尽量使用apply方法。

  // 删除字符
  val str_4 = str_0.drop(2)        // 从左边开始删除 n 个字符
  val str_5 = str_0.dropRight(1)   // 从右边开始删除 n 个字符

  // 替换字符串里面的字符
  val str_6 = str_0.replace("\'", "") // 替换字符串里面的字符
  val str_7 = str_0.replaceAll("""（.*?）+""", "") // 替换字符串里面所有字符

  // 拼接字符串
  val reStr1 = str_0.concat(str_1)
  val reStr2 = str_0.concat("ddd")
  val reStr3 = str_0 + str_1

  // 使用split方法分割字符串:
  // 注意: 这里的split使用的是正则表达式, 可以使用"""\s"""的方式避免使用转义字符
  val str3 = "pripid,entname"
  var str4 = ""
  str3.split(",").toList.map(x => str4 += x + ",")
  println(str3)
  println(str4.dropRight(1))
  // 使用Split案例, 需要留意转义字符的问题.
  val str1 = "https://www.jianshu.com/p/8614dd5ef24c?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation"
  str1.split("/").last.split("\\?").head
  str1.split("[，。；？！,.;?!]").foreach(println(_)) // 根据标点符号,将文本进行断句


  //使用多行字符
  //stripMargin 方法去掉默认的行分割符 | ，然后使用字符串的replaceAll方法转换成一行
  val str5 =
  """I have
    |a
    |Dream!
  """.stripMargin.replaceAll("\n", " ")

  val str6 = "Just do it!" :: Nil // 将一个字符串类型，转换成一个列表类型


  // 字符串插值：在字符串中插入变量
  // 字符串插值：2.10.0 版本以后：raw表示原生字符
  // Scala 提供了三种创新的字符串插值方法：s,f 和 raw
  // 待研究高级用法, 可以使用隐式转换, 来实现一个我们自己的插值字符, 例如json"{name:$name,age:$age}"这样的格式.

  // s 字符串插值
  val name1 = "DC"
  println(s"Hello,$name1") // 可以在字符串中插入任意变量
  println(s"1+1=${1 to 20}") // 可以在字符串中插入任意表达式

  // f 字符串插值,生成简单的格式化串,功能相似于其他语言中的printf函数.
  // 当使用f插值器的时候,所有的变量引用都应当后跟一个printf-style格式的字符串,如%d.
  val height = 1.9d
  val name2 = "DC"
  println(f"$name2%s is $height%1.4f meters tall") // %s and %1.4f  保留4位小数

  // raw 字符串插值, 保持原样不动
  val rawStr1 = "Hello\n,Word!" // 不使用raw插值的时候会\n会被解析成换行符
  val rawStr2 = raw"Hello\n,Word!" // 使用raw插入, 会保留原始字符.

  //TODO: 格式化字符串，需要学习

  // todo ： 排序
  val str_8 = str_0.sorted
}
