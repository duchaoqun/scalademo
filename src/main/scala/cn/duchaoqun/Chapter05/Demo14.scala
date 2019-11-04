package cn.duchaoqun.Chapter05

object Demo14 extends App {
  //  获取T类的数组，使用原始类型。
  //  scala> def mkArray[T : ClassTag](elems: T*) = Array[T](elems: _*)
  //  mkArray: [T](elems: T*)(implicit evidence$1: scala.reflect.ClassTag[T])Array[T]


  // TypeTag则保存所有具体的类型
  //  import scala.reflect.runtime.universe._

  //  def paramInfo[T](x: T)(implicit tag: TypeTag[T]): Unit = {
  //    val tags = tag.tpe match {
  //      case TypeRef(_, _, args) => args
  //    }
  //    println(s"type of $x has type arguments $tags")
  //  }
  //  scala> paramInfo(42)
  //  type of 42 has type arguments List()
  //  scala> paramInfo(List(1, 2))
  //  type of List(1, 2) has type arguments List(Int)
}
