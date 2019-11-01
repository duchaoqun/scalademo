package cn.duchaoqun.Chapter18

import java.awt.event.ActionEvent

import scala.collection.mutable.ArrayBuffer

object Demo13 extends App {

  // 如何对 那些跟着一起变化的类型家族 建模，同时共用代码，并保持类型安全，这是一个挑战。

  // 举例： Java 客户端的事件处理，有各种不同种类的事件（ActionEvent、ChangeEvent等），而每种类型都有单独的监听接口
  // （ActionListener、ChangeListener等），这就是家族多态。

  // 在 Java 中，每个监听器接口有各自不同的方法名称 对应事件的发生： actionPerformed stateChanged itemStateChanged 等等。
  // 我们将这些方法统一起来。
  trait Listener[E] {
    def occurred(e: E): Unit
  }

  // 而事件源需要一个监听器集合，和一个触发这些监听器的方法：
//  trait Source[E, L <: Listener[E]] {
//    private val listeners = new ArrayBuffer[L]()
//
//    def add(l: L): Unit = {
//      listeners += l
//    }
//
//    def remove(l: L): listeners.type = {
//      listeners -= l
//    }
//
//    def fire(e: E): Unit = {
//      for (l <- listeners) l.occurred(e)
//    }
//  }

  // 现在，我们来考虑按钮触发动作事件的情况，我们定义如下监听器类型：
  trait ActionListener extends Listener[ActionEvent]

  // Button 类可以混入 Source 特质：
//  class Button extends Source[ActionEvent , ActionListener]{
//    def click(): Unit = {
//      fire(new  ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Click"))
//    }
//  }

  // 任务完成：Button 类不需要重复那些监听器管理的代码，并且监听器是类型安全的，你没有办法给按钮加上 ChangeListener。

  // ActionEvent 类将事件源设置为 this，但是事件源的类型为Object，我们可以用自身类型让他也是类型安全的：

  trait Event[S]{
    var source: S = _
  }

  trait ListenerNew[S, E <: Event[S]]{
    def occurred(e: E): Unit
  }

  trait SourceNew[S, E <: Event[S], L <: ListenerNew[S, E]]{
    this: S =>
    private val listenters = new ArrayBuffer[L]()
    def add(l: L): Unit ={
      listenters += l
    }
    def remove(l: L): Unit ={
      listenters -= l
    }
    def ire(e: E): Unit ={
      e.source = this // 这里需要自身类型
      for (l <- listenters) l.occurred(e)
    }
  }
  // 注意自身类型 this: S => ，用来将事件源设为 this，否则 this 只能是某种 Source，而不一定是 Event[S] 所要求的类型。


}
