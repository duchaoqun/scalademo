package cn.duchaoqun.Chapter17

object Demo10 extends App {

  // 考虑泛型类型 Friend[T]，表示希望与类型 T 的人成为朋友的人。
  trait Friend[-T] {
    def befriend(someone: T) {}
  }

  class Person extends Friend[Person] {}

  class Student extends Person

  val susan = new Student
  val fred = new Person

  // 假设现在你有一个函数
  def makeFriendWith(s: Student, f: Friend[Student]) {
    f.befriend(s)
  }

  // 如下调用，如果 fred 愿意和任何人成为朋友，他一定也会想要成为 Susan 的朋友。
  makeFriendWith(susan, fred)

  // 注意类型变化的方向和子类型方向是相反的。
  // Student 是 Person 的子类型，但是 Friend[Student] 是 Friend[Person] 的父类型。
  // 对于这种情况，你需要将类型参数声明为“逆变”的。



  // 在一个泛型的类型声明中，你可以同时使用“协变”和“逆变”这两种型变。
  // 例如单参数函数的类型为 Function1[-A, +R]

  // 如下两种写法一致：
  def friends1(students: Array[Student], find: Function[Student, Person]): Array[Person] = for (s <- students) yield find(s)
  def friends2(students: Array[Student], find: Student => Person): Array[Person] = for (s <- students) yield find(s)

  // 假设有一个函数：def findStudent(p: Person): Student
  // 你能用这个函数调用 friends 吗？
  // 当然可以，它愿意接受任何 Person，因此当然也愿意接受 Student。
  // 它将产出 Student 结果，可以被放入 Array[Person]。
}
