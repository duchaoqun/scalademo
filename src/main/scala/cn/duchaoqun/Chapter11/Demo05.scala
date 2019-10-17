package cn.duchaoqun.Chapter11

object Demo05 extends App {
  /*
  优先级顺序：
  1. 最高优先级：除以下字符以外的操作符字符。
  2. * / %
  3. + -
  4. :
  5. < >
  6. ! =
  7. &
  8. ^
  9. |
  10. 非操作符
  11. 最低优先级：赋值操作符
  - 后置操作符的优先级低于中置操作符
   */
  val a = 1 + 2 * 3
  // 上面表达式中最先执行的是“*”操作符
  println(a)
}