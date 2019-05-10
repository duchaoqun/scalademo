package info.aoye.Chapter6

/**
  * 6.3 扩展类或特质的对象
  * 一个Object可以扩展类以及一个或者多个特质，其结果是扩展了指定类以及特质的类的对象，同时拥有在对象定义中给出的所有特性。
  * 场景：给出可以被共享的默认对象。
  */
object Demo6_2 extends App {
  val actions = Map("open" -> DoNothingAction,"save" -> DoNothingAction)
}

abstract class UndoableAction(val description:String){

  def undo():Unit

  def redo():Unit

}

/**
  * DoNothingAction对象可以被所有需要这个默认行为的地方共用。
  */
object DoNothingAction extends UndoableAction("Do nothing"){

  override def redo(): Unit = {}

  override def undo(): Unit = {}

}
