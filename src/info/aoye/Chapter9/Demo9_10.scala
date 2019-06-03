package info.aoye.Chapter9

/**
  * 9.10 正则表达式
  */
object Demo9_10 extends App {
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
}
