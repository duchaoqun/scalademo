package cn.duchaoqun.Chapter14

object Demo08 extends App {

  // 你可以在 for 推导式中使用带变量的模式，对于每一个被遍历到的值，这些变量都会被绑定。

  import scala.jdk.CollectionConverters._

  // 遍历系统所有环境变量
  for ((key, value) <- System.getProperties.asScala){
    println(key + value)
  }

  // 在 for 推导式中，失败的匹配会被忽略，如下会找到所有值为空的键，然后打印出来。
  for ((key, "") <- System.getProperties.asScala){
    println(key)
  }

  // 十三亿守卫达到同样的效果。
  for ((key, value) <- System.getProperties.asScala if value == ""){
    println(key + value)
  }
}
