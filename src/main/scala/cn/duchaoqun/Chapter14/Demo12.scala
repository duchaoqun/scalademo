package cn.duchaoqun.Chapter14

object Demo12 extends App {

  sealed abstract class TraficLightColor

  case object Red extends TraficLightColor

  case object Yellow extends TraficLightColor

  case object Green extends TraficLightColor

  val color = Red

//  color match {
//    case Red: TraficLightColor => "Stop"
//    case Yellow: TraficLightColor => "Hurry up"
//    case Green: TraficLightColor => "go"
//  }

}
