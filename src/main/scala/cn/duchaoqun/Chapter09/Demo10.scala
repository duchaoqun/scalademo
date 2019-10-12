package cn.duchaoqun.Chapter09

/**
  * 9.10 正则表达式
  */
object Demo10 extends App {
  import scala.util.matching.Regex
  val numPattern = "[0-9]+".r

  // 使用原始字符的方式，如果使用转移符号太难看了。
  val wsnumsPattern = """\s+[0-9]+\s+""".r

  // findAllIn 返回所有匹配项的迭代器
  for ( x <- numPattern.findAllIn("1 one, 2 two, 3 three")){
    println(x)
  }

  // 返回首个匹配项，得到的结果是Option[String]类型
  val firstMatch = numPattern.findFirstIn("1 one, 2 two, 3 three")

  // 要检查字符串的开头是否能匹配
  numPattern.findPrefixOf("1 one, 2 two, 3 three")

  //替换找到的匹配项
  numPattern.replaceFirstIn("1 one, 2 two, 3 three","XXX")
  numPattern.replaceAllIn("1 one, 2 two, 3 three","XXX")

  // 1. 在使用字符进行匹配的时候, 我们尽量使用三引号.

  // 常用的一些正则规则
  val regURL:Regex  = """^(ht|f)tps?:\\/\\/([\\w\\-]+(\\.[\\w\\-]+)*\\/)*[\\w\\-]+(\\.[\\w\\-]+)*\\/?(\\?([\\w\\-\\.,@?^=%&:\\/~\\+#]*)+)?""".r
  val regIPv4:Regex = """(?=(\b|\D))(((\d{1,2})|(1\d{1,2})|(2[0-4]\d)|(25[0-5]))\.){3}((\d{1,2})|(1\d{1,2})|(2[0-4]\d)|(25[0-5]))(?=(\b|\D))""".r
  val regIPv6:Regex = """^([\\da-fA-F]{1,4}:){7}([\\da-fA-F]{1,4})$""".r

  //使用String类的r()方法构造了一个Regex对象
  val pattern = """Scala""".r
  val str = "Scala is Scalable and cool"

  //返回匹配的第一个内容,如下两个写法是一样的 返回 Option[Regex.Match]
  pattern findFirstIn str //Some(Scala)
  pattern.findFirstIn(str) //Some(Scala)

  //匹配字符+数字
  val pattern1 = new Regex("abl[ae]\\d+")
  val str1 = "ablaw is able123 and cool"

  (pattern1 findAllIn str1).mkString(",") //able123
  (pattern1 findAllIn str1).getClass //class scala.util.matching.Regex$MatchIterator

  //匹配所有内容,findAllln方法返回遍历所有匹配项的迭代器,你可以在for循环中使用它
  val numPattern1 = raw"\d+".r
  for (matchString <- numPattern1.findAllIn("99 bottles, 98 bottles")) {
    //println(matchString)  //99 98
  }

  //使用分组
  val pattern3 = raw"(\d+)/(\d+)".r //在模式中定义了两个组
  val str3 = "2018/08/232"
  for (pattern3(one, two) <- pattern3.findAllIn(str3)) { //模式对象中保存的就是组中对应的内容, 如果上面只有一个组,这里也必须定义一个参数对象.
    //println(one)  //2018
    //println(two)  //08
  }


  /*

  模式匹配部分内容.
  正则表达式, 批判三组数字, 年 月 日

  */
  val date = raw"(\d{4})-(\d{2})-(\d{2})".r

  // 要在匹配正则表达式时提取捕获组, 在模式匹配中使用它作为提取器
  "2004-01-20" match {
    case date(year, month, day) => s"$year was a good year for PLs." // 取出三组内容, 分别存放到year month day 中, 然后后面使用.
  }

  // 要检查正则表达式是否匹配,忽略任何组, 使用一个序列通配符:
  "2004-01-20" match {
    case date(_*) => "It's a date!"
  }

  // 这是因为一个Regex提取器生成一个字符串序列, 从日期提取的年份也可以用一个序列通配符来表示:
  "2004-01-20" match {
    case date(year, _*) => s"$year was a good year for PLs."
  }

  // 在模式匹配中, Regex通常与整个输入匹配. 然而, 一个没有锚定的Regex在输入的任何地方都能找到这种模式。
  val embeddedDate = date.unanchored
  "Date: 2004-01-20 17:25:18 GMT (10 years, 28 weeks, 5 days, 17 hours and 51 minutes ago)" match {
    case embeddedDate("2004", "01", "20") => "A Scala is born."
  }

  // findFirstIn and findFirstMatchIn 匹配第一个内容
  val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
  val firstDate = date.findFirstIn(dates).getOrElse("No date found.")       //2004-01-20  //返回Some对象(使用getOrElse方法)
  val firstYear = for (m <- date.findFirstMatchIn(dates)) yield m.group(1)  //Some(2004)  //返回Some对象

  // findAllMatchIn 匹配所有内容, 返回一个迭代器Iterator
  val allYears = for (m <- date.findAllMatchIn(dates)) yield m.group(1)     //Iterator 所有内容
  println(allYears.getClass)
  // TODO key word yield.

  // findAllIn 返回一个特殊的迭代器, 可以对其进行相关的判断.
  val mi = date.findAllIn(dates)
  while (mi.hasNext) {
    val d = mi.next  // mi移动到下一个元素, 并保持元素位置, 可以访问这个元素.
    if (mi.group(1).toInt < 1960) println(s"$d: An oldie but goodie.")
  }

  // 位移的具体点.
  val partternA = raw"(ab+c)".r
  val str4 = "xxxabcyyyabbczzz"
  val m1 = partternA.findAllIn(str4)
  m1.hasNext  // true  移动位置到第一个匹配内容.
  m1.start    // 3
  m1.next()   // "abc"
  m1.start    // 3
  m1.hasNext  // true  移动位置到第二个匹配内容.
  m1.start    // 9
  m1.next()   // "abbc"
}
