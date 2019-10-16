package cn.duchaoqun.Chapter07

class Person {
  // 以下方法，在它所在的 Chapter07 包中可见。
  private[Chapter07] def description1 = "A person"

  // 将可见度延申到上层的包中。
  private[duchaoqun] def description2 = "A person"
}

object Demo06 extends App {

}


