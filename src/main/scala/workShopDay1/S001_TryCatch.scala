package workShopDay1

object S001_TryCatch extends App {

  val result = try {
    42/3
  } catch  {
    case e : ArithmeticException => -2
    case e: ArrayIndexOutOfBoundsException => -3
    case _ => -1
  } finally {
    println("In the finally block")
  }
  println("Program execution completes, result is " + result)
}
