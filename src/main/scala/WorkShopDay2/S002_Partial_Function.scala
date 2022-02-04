package WorkShopDay2

object S002_Partial_Function extends App {

  val divide = new PartialFunction[Int, Int] {
    //Put business logic in apply
    def apply(x: Int): Int = 42 / x

    // Pre condition, this function will be called to know whether to accept
    // arg x or not. It returns Boolean,
    // If true then apply can be called. If false, apply can't ve called
    def isDefinedAt(x: Int) = x != 0
  }

  println(divide.isDefinedAt(2))
  println(divide.isDefinedAt(0))

  if (divide.isDefinedAt(2)) println("Divide by 2: " + divide(2))

  // Shorter approach to write partial function
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }

  println(divide2.isDefinedAt(0))
  println(divide2.isDefinedAt(2))

  if (divide2.isDefinedAt(2)) println(divide2(2))

  // Few scala functions respect partial functions
  val list: List[Double] = List(4, 16, 25, -9)
  val squareroot: PartialFunction[Double, Double] = {
    case d: Double if d > 0 => Math.sqrt(d)
  }

  /*val result = list.map(squareroot)   // This is causing exception as -9 is a negative no
  println("list with partition: " +result)*/

  val result2 = list.collect(squareroot) // It will call isDefinedAt to validate the parameter
  println("list with collect: " + result2)
}
