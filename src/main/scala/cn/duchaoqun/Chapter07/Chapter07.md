  * 1. import语句可以出现在任何地方,而不是只能在文件顶部.
  * 2. import的效果从开始延伸到语句块的结束.这可以大幅减少名称冲突的可能性.
  * 3. 默认情况scala总会引入java.lang._ scala._ 和 Predef._ 这里也能解释,为什么以scala开头的包,在使用时都是省去scala.
  * 注意:上述三个语句的顺序藏着一点玄机,我们知道,通常,如果import进来两个包都有某个类型的定义的话,比如说,同一段程序,
  * 即引用了'scala.collection.mutable.Set'又引用了'import scala.collection.immutable.Set'则编译器会提示无法确定用哪一个Set.
  * 这里的隐式引用则不同,如果有相同的类型,后面的包的类型会将前一个隐藏掉.
  * 比如java.lang和scala两个包里都有StringBuilder这种情况下会使用scala包里定义的那个.java.lang里的定义就被隐藏掉了,
  * 除非显示的使用java.lang.StringBuilder
  *
  * 4. 引入一个包的所有内容需要添加._ 标记, 例如scala.math._
  
  
  
import java.lang._  //默认导入
import scala._      //默认导入
import Predef._     //默认导入: 包含大部分基本的转换


import scala.math._