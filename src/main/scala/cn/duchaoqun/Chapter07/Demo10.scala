package cn.duchaoqun.Chapter07

/**
  * 7.10 隐式引入
  * 默认情况下：scala会隐式的引入三个包
  * import java.lang._
  * import scala._
  * import Predef._
  * 和Java程序一样，java.lang总会被引入。
  * 接下来scala包也被引入，不过方式有些特殊，不像所有其他引入，这个引入会覆盖之前的引入。例如scala.StringBuffer会覆盖
  * java.lang.StringBuffer而不是产生冲突。
  * 最后是Predef包，这个包中包含了很多有用的函数。
  */
object Demo10 extends App {
  //然后再写引入的时候就可以省略scala前缀
  import collection.mutable.HashMap
}
