package WorkShopDay2

object S002_FunctionCompose extends App {
  //f(g(x)) - g(x) will be evaluated first and return a value for f(return value) to get executed
  // Compose is a feature, it basically compose functions together
  // f compose g => f(g(x)) -> g will execute first then f
  // f and then g => g(f(x)) -> f will execute first then g
  val f = (x: String) => s"f($x)"
  val g = (x: String) => s"g($x)"

  val fComposeG = f compose g // this creates a function f(g(x))
  println(fComposeG("x"))

  val fAndThenG = f andThen g
  println(fAndThenG("x"))

  val gst = (v:Double) => v + v * .18
  val discount = (v:Double) => v - v * .10
  val price = (v:Double) => v

  val c = price compose discount compose gst
  println (c(100))
}
