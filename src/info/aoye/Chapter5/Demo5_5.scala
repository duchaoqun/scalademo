package info.aoye.Chapter5

/**
  * 5.5 Bean属性【L1】
  * 定义符合JavaBean规范的类（包含getXxx和SetXxx的方法等）
  */
object Demo5_5 extends App {

}

// import scala.reflect.BeanProperty // 早期在这里
import scala.beans.BeanProperty // 当前版本为2.12.4

// 在主构造器中使用
class Person00(@BeanProperty var name:String){
  // 引入包之后，填完注解即可
  @BeanProperty
  var age:Int = _
}
