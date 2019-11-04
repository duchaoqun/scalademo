package cn.duchaoqun.Chapter05

object Demo13 extends App {

  // classOf 获取运行时的类型。classOf[T] 相当于 Java 中的 T.class。
  val listClass = classOf[List[_]]
  // listClass is java.lang.Class[List[_]] = class scala.collection.immutable.List
  val mapIntString = classOf[Map[Int,String]]
  // mapIntString is java.lang.Class[Map[Int,String]] = interface scala.collection.immutable.Map


  class A

  val a = new A
  val a1 = classOf[A]  // Class[A] = class A
  a.getClass // Class[_ <: A] = class A  下边界 _ <: A 表示 A 类型的子类。
  // getClass 方法得到的是 Class[A]的某个子类，而 classOf[A] 得到是正确的 Class[A]，但是去比较的话，这两个类型是 equals 为 true 的。
  // 这种细微的差别，体现在类型赋值时，因为 Java 里的 Class[T] 是不支持协变的，所以无法把一个 Class[_ < : A] 赋值给一个 Class[A]。
}
