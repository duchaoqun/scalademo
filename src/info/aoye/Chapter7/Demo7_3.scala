package info.aoye.Chapter7

/**
  * 7.3 串联式包语句
  * 这样的语句限定了可见的成员
  */
object Demo7_3 extends App {

}

package com.horstman.impatient{
  // com 和 horstman的成员在这里不可见
  package people{
    class Person
  }
}
