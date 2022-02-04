package workShopDay1

object S001_Functions extends App {

  //Functions are objects, can be passed as arguement, returned as value
  // Called as lambda in java
  // anaonymous, no name only reference

  //no arg, no return type
  val show= () => println("Hello")

  // accepts 1 arg and returns square of number as output
  val power = (n:Int) => n*n

  // Multiline function
  // accepts 2 arguements and return a value
  val add = (num1: Int, num2: Int) => {
    num1+num2 // return value
  }

  show()

  println("calculate power of 8: " + power(8))
  // Every function has apply method , Scala does this apply automatically
  println("calculate power of 8: " + power.apply(8))

  println("calculate sum of 5 & 6: " + add(5,6))
  println("calculate sum of 5 & 6: " + add.apply(5,6))
}
