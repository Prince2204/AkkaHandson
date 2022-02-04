package workShopDay1

object S001_if extends App {

  // in scala if is an expression
  val result = if (10 % 2 == 0) "Even" else "Odd"
  println("Result is :" + result)

  val result2 = if (10 > 5) {
    println(" 10 is greator than 5")
    10
  } else {
    println("5 is less than 10")
    5
  }

  println(result2)

  def oddOrEven(n: Int): String = if (n % 2 == 0) "Even" else "Odd"

  println("Check if 10 is odd/even: " +oddOrEven(10))
  println("Check if 5 is odd/even: " +oddOrEven(5))
}