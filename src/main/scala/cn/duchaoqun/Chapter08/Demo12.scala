package cn.duchaoqun.Chapter08

object Demo12 extends App {

  // 举例来说，有如下定义，你可能认为两个物件有相同的描述和相同的价格，就说明它们相等。
  class Item(val description: String, val price: Double){

    // 我们将用 final 来修饰这个方法，因为通常在子类中正确的扩展相等性判断非常困难。
    // 问题出在对称性上，你想让 a.equals(b) 和 b.equals(a) 的结果相同，尽管 b 属于 a 的子类。
    // 注意：equals 的参数类型必须是 Any。
    final override def equals(other: Any){
      // 将目标对象转换成当前类型
      val that = other.asInstanceOf[Item]

      // 判断是否相等
      if ( that == null) false
      else description == that.description && price == that.price
    }

    // 在你重写 equals 的时候，记得重写 hashCode 方法，计算 hash 时，只应该使用那些你用来做相等性判断的字段。

    final override def hashCode(): Int = {
      13 * description.hashCode + 17 * price.hashCode()
    }

    // 通常我们不需要重新定义 equals 和 hashCode 方法，对于大多数类来说，将不同的对象看作不相等是很正常的。

    // 在实际的编程中，我们通常不直接调用 eq 和 equals 方法，只需要使用“==”操作符即可，对于类型来说。
    // 它会在做完必要的 null 检查之后调用 equals 方法。
  }
}
