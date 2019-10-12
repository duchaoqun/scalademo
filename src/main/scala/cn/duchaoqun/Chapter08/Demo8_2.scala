package cn.duchaoqun.Chapter08

/**
  * 8.2 重写方法
  * 在Scala中重写一个非抽象的方法必须使用 override 关键字
  */
object Demo8_2 extends App {

}

class Demo8_2_1 extends Person{
  override val name: String = "Java"
  // 调用父类的方法和Java一样，使用super关键字。
  override def toString: String = super.toString + "Scala"
}

/*
场景：
假设程序员Alice 定义了一个Person类，在Alice完全不知情的情况下，Bob定义了一个子类Student，和一个id方法，返回学生id
后来Alice在Person类中也添加了一个id方法，对应这个人员的全国ID。
当Bob拿到这个修改后，Bob的程序可能会有问题(在Alice的案例中不会有问题)，因为返回的不是预期的id了。
在Java中通常的“建议”解决方案是将所有方法都使用final修饰，除非他们显示的被设计用户重用。
 */
