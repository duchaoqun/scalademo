package cn.duchaoqun.Chapter09

object Demo11 extends App {
  val numitemPattern = "([0-9]+)([z-a]+)".r

  // 要匹配组，可以将正则表达式对象当作“提取器”，直接提取内容
  val numitemPattern(num,item) = "99 bottles"

  // 从多个匹配项中提取分组内容
  for (numitemPattern(num, item)<- numitemPattern.findAllIn("99 bottles 99 bottles")){
    println(num + item)
  }
}
