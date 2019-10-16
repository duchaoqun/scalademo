package cn.duchaoqun.Chapter06

object Demo03 extends App {

  abstract class UndoableAction(val description: String) {
    def undo(): Unit
    def redo(): Unit
  }

  // DoNothingAction 对象可以被所有需要这个默认行为的地方共用。
  object DoNothingAction extends UndoableAction("Do nothing") {
    override def redo(): Unit = {}
    override def undo(): Unit = {}
  }

  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
}


