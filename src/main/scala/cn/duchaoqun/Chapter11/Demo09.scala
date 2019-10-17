package cn.duchaoqun.Chapter11

object Demo09 extends App {

  object Name {
    def unapplySeq(input: String): Option[Array[String]] = {
      if ( input.trim == "") None
      else Some(input.trim.split("\\s+"))
    }
  }

  val author = "Chris Du A"

  // 然后就可以匹配任意长度的序列了。
  author match {
    case Name(first: String, last: String) => println(first + ":" + last)
    case Name(first: String, second: String, thrid: String) => println(first + ":" + second +  ":" + thrid)
  }


}
