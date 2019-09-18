package cn.duchaoqun.DemoGUI

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.{Button, CheckBox, RadioButton, TextField}
import javafx.scene.layout.FlowPane
import javafx.stage.Stage
import sun.applet.Main

object DemoMain {
  /**
    * 程序启动
    * @param args 启动参数
    */
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[DemoMain], args: _*)
  }
}

/**
  * 继承 Application 对象，重构我们的主要方法。
  */
class DemoMain extends Application {

  /**
    * 程序启动
    * @param primaryStage 主要舞台
    */
  override def start(primaryStage: Stage): Unit = {

    // 创建流动窗格对象，并设置属性
    val flowPane = new FlowPane()
    flowPane.setHgap(10)
    flowPane.setVgap(20)
    flowPane.setPadding(new Insets(10,10,10,10))

    // 创建一些基本控件
    val button1 = new Button("Button1")
    val button2 = new Button("Button2")
    button2.setPrefSize(100,100)

    val textField = new TextField("Text Field.")
    textField.setPrefSize(100,100)

    val checkBox = new CheckBox("Check Box")
    val radioButton = new RadioButton("Radio Button")

    // 将基本控件添加到窗格上
    flowPane.getChildren.addAll(button1,button2,textField,checkBox,radioButton)


    // 场景对象
    val scene = new Scene(flowPane,1024,768)
    // 设置标题
    primaryStage.setTitle("Test FlowPane")
    // 舞台加载场景
    primaryStage.setScene(scene)
    // 展示页面
    primaryStage.show()
  }
}

