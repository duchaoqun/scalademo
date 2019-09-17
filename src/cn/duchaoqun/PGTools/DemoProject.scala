package cn.duchaoqun.PGTools

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.scene.Scene
import javafx.scene.control._
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.stage.Stage

object DemoProject {
  /**
    * 程序启动
    * @param args 启动参数
    */
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args: _*)
  }
}


class Main extends Application{
  override def start(primaryStage: Stage): Unit = {
    // 创建一个边界窗格
    val root = new BorderPane()
    val scene = new Scene(root,1024,768, Color.WHITE)

    val menuBar = new MenuBar()
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty())
    root.setTop(menuBar)

    // 创建菜单
    val overviewMenu = new Menu("Overview")
    val connectionMenu = new Menu("Connections")
    val sessionsMenu = new Menu("Sessions")
    val checkpoints = new Menu("Checkpoints")
    val tempFilesMenu = new Menu("Temp Files")
    val locksMenu = new Menu("Locks")
    val queriesMenu = new Menu("Queries")
    val eventMenu = new Menu("Events")
    val configMenu = new Menu("Config")





    // 创建菜单项
    val configMenuItem1 = new MenuItem("Connection")
    configMenu.getItems.addAll(configMenuItem1)

    configMenuItem1.setOnAction((event: ActionEvent) =>{
      println("Hello World!")
    })

    menuBar.getMenus.addAll(overviewMenu, connectionMenu, sessionsMenu, checkpoints, tempFilesMenu, locksMenu, queriesMenu, eventMenu, configMenu)

    primaryStage.setTitle("Aoye")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}