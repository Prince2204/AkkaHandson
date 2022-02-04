package workShopDay1

object S001_HigherOFunction extends App {
  // A functions that accepts another function as parameter

  // Sum of sq / cube / tan/ cosine of numbers
  val square = (s: Double) => s * s
  val cube = (c: Double) => c * c * c
  val tanOfNum = (n: Double) =>Math.tan(n)

  //func: Double => Double means the function accepts one double arguement
  // and returns one double arguement
  // below sum method is higher order function as it accepts another function as input
  val sum = (nums: List[Double], func: Double => Double ) => {
    var result = 0.0
    for (n <- nums) {
      result += func(n)
    }
    result
  }

  val data = List(2.0,3.0,4.0)

  println ("sum of square of nums is:" +sum(data,square))
  println ("sum of cube of nums is:" +sum(data,cube))
  println ("sum of tan of nums is:" +sum(data,tanOfNum))
  println ("sum of log of nums is:" +sum(data,Math.log))
}
