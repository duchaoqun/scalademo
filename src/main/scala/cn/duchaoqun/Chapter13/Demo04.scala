package cn.duchaoqun.Chapter13

object Demo04 extends App {

  // 创建一个空列表对象
  val list_6 = Nil
  val list_1: List[Int] = List(1, 2, 3, 4, 5)  // 创建一个 List[Int] 类型的列表
  val list_7: List[Map[String, String]] = Nil  // 定义其他对象的列表
  val list_8 = List(1, 2, 3, "44", "55", "66") // 包含不同类型对象的列表

  // 列表有两个形态：
  // 1. 只是一个 Nil 空列表。
  // 2. 一个 head 元素，和一个 tail 列表。（tail 列表也是这么组成的，直到 tail 是 Nil）
  println(list_1.head)
  println(list_1.tail)


  // 操作符【::】注意该操作符是右结合的，在列表前面添加元素，返回新列表。
  // 1. 指定一个 head 元素为 0 ，tail 列表为 list_1，创建一个新的列表。
  val list_2 = 0 :: list_1
  // 2. 指定所有元素，最后一个是 Nil。
  val list_3 = 0 :: 1 :: 2 :: 3 :: Nil
  val list_4 = (0 :: (1 :: (2 :: (3 :: Nil)))) // 右结合


  // 操作符【:+】在列表后面添加新元素，返回新列表。
  val list_9 = list_1 :+ 9


  // 操作符【:::】拼接两个列表，返回新列表
  val list_10 = list_1 ::: list_2


  // 遍历链表
  // 计算整型链表中所有元素的和
  def sum_1(list: List[Int]): Int = {
    if (list == Nil) 0 else list.head + sum_1(list.tail)
  }

  // 使用模式匹配计算整型链表中所有元素的和
  def sum_2(list: List[Int]): Int = list match {
    case Nil => 0
    case head :: tail => head + sum_2(tail)
  }

  // 使用类库中 sum 方法
  val list_5 = List(1, 2, 3, 4, 5)
  val res1 = list_5.sum


  // 访问列表元素
  println(list_1(0)) // 返回列表中坐标为 0 的值，列表以 0 开始。


  // 类库中的方法
  list_1.drop(1)      // 删掉最前面的一个元素，最左边。
  list_1.dropRight(1) // 删掉最后面的一个元素，最右边。
  list_1.head         // 返回列表的第一个元素。
  list_1.tail         // 返回除列表第一个元素组成的新列表，如果列表中仅有一个元素，这里返回Nil。
  list_1.last         // 返回列表的最后一个元素

  list_1.init //返回除列表最后一个元素组成的新列表

  // 其他待研究
  //list_1.count(a => a.length == 1) //计算列表中字符长度为1的元素个数, 遍历列表？ 传递给a？ 判断a的长度？
  list_1.exists(s => s == "B") //判断“B” 是否在列表里面,如果在返回true
  //list_1.filter(s => s.length == 2) //过滤列表中的内容,将长度为2的取出来,返回一个新列表
  //list_1.forall(s => s.endsWith("C")) //判断列表里面的元素是否都是以C结尾
  list_1.foreach(s => print(s)) //对列表中的每个字符执行print
  list_1.foreach(print) //对列表中的每个字符执行print
  list_1.isEmpty //判断列表是否为空
  list_1.length //列表长度
  list_1.map(s => s + "D") //返回列表每个元素都+D的新列表
  list_1.mkString(",") //将列表组成字符串,用逗号分隔
  list_1.reverse //返回倒序新列表



  //排序
  val list8: List[Int] = List(5, 7, 9, 3, 1, 2, 3, 4)
  println(list8.sortWith((x, y) => x > y)) //List(9, 7, 5, 4, 3, 3, 2, 1) 使用自己定义的方法进行,可以对复杂对象排序
  println(list8.sorted)
  println(list8.sum) //计算列表中所有数字的和

  /**
    * 案例A
    * 1. flatMap扁平化操作,处理每个对象,然后合并在一起
    * 2. 对每一个元素标记为1,进行计数
    * 3. 获取Tuple中的第二个元素,数量,都是1      注意! 注意! 注意! 如果操作的对象只有一个元素, 元素类型是固定的, 可以简写成.map(_._2),使用占位符替代
    * 4. 使用reduce进行加数操作?
    */
  //val listA = List("I am into Spark so much!", "Scala is powerful!").flatMap(x => x.split(" ")).map(x => (x, 1)).map(x => x._2).reduce((x, y) => x + y) //累加
  //val listA1 = List("I am into Spark so much!", "Scala is powerful!").flatMap(_.split(" ")).map((_, 1)).map(_._2).reduce(_ + _) //使用_简写形式
  //val listA2 = List("I am into Spark so much!", "Scala is powerful!").flatMap(_.split(" ")).map((_, 1)).map(_._2).sum //使用sum替代reduce的计数

  // 补充: 关于占位符的简化演变过程.当元素确定,就可以使用占位符了.
  List(1, 2, 3, 4, 5).foreach(x => println(x))
  List(1, 2, 3, 4, 5).foreach(println(_))
  List(1, 2, 3, 4, 5).foreach(println _)
  List(1, 2, 3, 4, 5).foreach { println _ }
  List(1, 2, 3, 4, 5, 6) foreach println

  val list1 = List(1,2,3)

  // zip 操作需要学习
  println(list1.zip(List(4,5,6)))
}
