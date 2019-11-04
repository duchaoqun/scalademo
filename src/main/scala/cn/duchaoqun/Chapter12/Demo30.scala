package cn.duchaoqun.Chapter12

object Demo30 extends App {

  // 定义好一个函数有 3 个参数，
  def add(x: Int, y: Int, z: Int) = x + y + z

  // 再提供几个有 1 个已知参数的偏应用函数
  def addX = add(1, _: Int, _: Int) // x 已知  // addX: (Int, Int) => Int

  addX(2, 3)  // 6
  addX(3, 4)  // 8

  def addXAndY = add(10, 100, _: Int) // x 和 y 已知 // addXAndY: Int => Int

  addXAndY(1) // 111

  def addZ = add(_: Int, _: Int, 10) // z 已知 //addZ: (Int, Int) => Int
  addZ(1, 2)  // 13
}
