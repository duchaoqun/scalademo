package cn.duchaoqun.DemoAkka


/**
  * 获取当前所有的线程
  */
object Demo04 extends App {
  var group = Thread.currentThread().getThreadGroup

  var topGroup = group

  while (group != null){
    topGroup = group
    group = group.getParent
  }


  // 激活的线程数加倍
  val estimatedSize = topGroup.activeCount * 2
  val slackList = new Array[Thread](estimatedSize)
  // 获取根线程组的所有线程
  val actualSize = topGroup.enumerate(slackList)
  // copy into a list that is the exact size
  val list = new Array[Thread](actualSize)
  System.arraycopy(slackList, 0, list, 0, actualSize)
  System.out.println("Thread list size == " + list.length)
  for (thread <- list) {
    System.out.println(thread.getName)
  }

  Thread.sleep(100000)
}
