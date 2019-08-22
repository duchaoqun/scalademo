package info.aoye.DemoGUI
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.{Button, CheckBox, RadioButton, TextField}
import javafx.scene.layout.FlowPane
import javafx.stage.Stage
import sun.applet.Main

object Demo_01 {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args: _*)
  }

}

class Main extends Application {
  override def start(primaryStage: Stage): Unit = {
    val flowPane = new FlowPane()
    flowPane.setHgap(10)
    flowPane.setVgap(20)
    flowPane.setPadding(new Insets(10,10,10,10))

    val button1 = new Button("Button1")
    val button2 = new Button("Button2")
    button2.setPrefSize(100,100)

    val textField = new TextField("Text Field.")
    textField.setPrefSize(100,100)

    val checkBox = new CheckBox("Check Box")
    val radioButton = new RadioButton("Radio Button")
    flowPane.getChildren.addAll(button1,button2,textField,checkBox,radioButton)


    val scene = new Scene(flowPane,550,250)

    primaryStage.setTitle("Test FlowPane")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

