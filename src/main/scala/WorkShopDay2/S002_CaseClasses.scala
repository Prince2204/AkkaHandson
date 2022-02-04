package WorkShopDay2

object S002_CaseClasses extends App {
  // case class is used to represent facts
  // Once created case class objects are immutable. Once created it can't be changed
  // id & amount are member variable.
  // Case classes have companion objects inbuilt, hence no need to use new keyword
  case class Order (id: Int, amount: Double)

  val order1 = Order(1,100.50)
  val order2 = Order(2, 45.75)

  println("Order 1: ", order1.id, order1.amount)
  println("Order 2: ", order2)

}
