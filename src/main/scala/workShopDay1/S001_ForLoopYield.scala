package workShopDay1

object S001_ForLoopYield extends App {

  //for yield is an expression that returns output
  // if condition in yield guards output
  val evenNumbers = for (n <- 1 to 10 if n % 2 == 0) yield n
  println("Even: " + evenNumbers)
  val multBy10 = for (n <- 1 to 10 ) yield n * 10
  println("10 times multiplied no: " + multBy10)
  val names = List("Scala","Akka","Java")
  val upperCase = for (name <- names) yield name.toUpperCase()
  println("Uppercase of names :" + upperCase)

  //for yield with nested loops
  // (n,c) represents tuple
  val results = for {
    n <- 1 to 3
    c <- Seq('a','b','c')
    if (n !=2 && c != 'c')
  } yield (n, c)

  println(results)
}
