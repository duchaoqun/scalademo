package cn.duchaoqun.Chapter02

object Demo04 extends App {
  print("末尾没有换行符：")
  println("末尾有换行符：")
  printf("格式化字符%s + %d", "字符", 123)

  // 从控制台输入，这里都提示过期的方法，以后看看要用什么来做。
  // 在 2.13.0 中去掉了 readLine 方法？
  // val x = readLine(" 请输入: ")
  // val y = readInt()
}
