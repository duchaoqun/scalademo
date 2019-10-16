package cn.duchaoqun.Chapter07

object Demo07 extends App {
  // 引入之后你就可以使用较短的名称Timer，而不是java.util.Timer
  import java.util.Timer

  // 引入包，下划线作为通配符，引入所有内容，就相当于Java中的math.*;
  import math._
  import cn.duchaoqun.Demo._    // 使用占位符的方式导入优先级比直接导入要低。
  import cn.duchaoqun.Demo.Man  // 直接导入的优先级要高于使用占位符。
}
