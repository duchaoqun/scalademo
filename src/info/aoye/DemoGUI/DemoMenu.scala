package info.aoye.DemoGUI

import javafx.application.{Application, Platform}
import javafx.scene.Scene
import javafx.scene.control._
import javafx.scene.layout.{BorderPane, FlowPane}
import javafx.scene.paint.Color
import javafx.stage.Stage

object DemoMenu {
  /**
    * 程序启动
    * @param args 启动参数
    */
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[DemoMenuMain], args: _*)
  }
}

class DemoMenuMain extends Application{
  override def start(primaryStage: Stage): Unit = {
    // 创建一个边界窗格
    val root = new BorderPane()
    // 创建一个场景，并初始化一些基本属性
    val scene = new Scene(root,1024,768, Color.WHITE)

    // 先创建一个“菜单栏”对象，才可以保存Menu对象。
    val menuBar = new MenuBar()
    // 设置基本属性，和菜单条位置。
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty())
    root.setTop(menuBar)

    // 创建“File”菜单
    // Menu 对象可以添加 MenuItem 对象，也可以添加 Menu 对象，作为二级菜单。
    val fileMenu = new Menu("File")

    // 创建菜单项
    val newMenuItem = new MenuItem("New")
    val saveMenuItem = new MenuItem("Save")
    val exitMenuItem = new MenuItem("Exit")

    // 将 MenuItem 添加到 Menu 中
    //exitMenuItem.setOnAction(actionEvent -> Platform.exit())
    fileMenu.getItems.addAll(newMenuItem, saveMenuItem, exitMenuItem)

    // 第一个菜单，CheckMenuItem 对象，多选菜单。
    val menuDB = new Menu("DataBase")
    val postgresQL = new CheckMenuItem("PostgresQL")   // 多选菜单项
    postgresQL.setSelected(true)
    val oracle = new CheckMenuItem("Oracle")            // 多选菜单项
    oracle.setSelected(true)
    menuDB.getItems.addAll(postgresQL, oracle)


    // 第二个菜单，RadioMenuItem 对象，单选菜单。
    val menuLanguage = new Menu("Language")
    // 开关组，并在组内添加两个 RadioMenuItem 对象。
    val tGroup = new ToggleGroup
    val scala = new RadioMenuItem("Scala")
    scala.setToggleGroup(tGroup)
    scala.setSelected(true)
    val java = new RadioMenuItem("Java")
    java.setToggleGroup(tGroup)
    menuLanguage.getItems.addAll(scala, java)

    // 二级菜单
    val secondMenu = new Menu("Second")
    secondMenu.getItems.addAll(
      new CheckMenuItem("A"),
      new CheckMenuItem("B"),
      new CheckMenuItem("C")
    )
    menuLanguage.getItems.add(secondMenu)


    menuBar.getMenus.addAll(fileMenu, menuDB, menuLanguage)

    primaryStage.setTitle("Aoye")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}