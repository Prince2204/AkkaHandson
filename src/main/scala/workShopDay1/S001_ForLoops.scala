package workShopDay1

//scala hai do... while, while ,for loop
object S001_ForLoops extends App {
  // for[statement] , for yield [Expression]

  val range = 1.to(10)  // Collections
  val range2 = 1 to 10  // Collections

  //for loop statement
  //Single line
  for (i <- range) println(i)

  // Multiline
  for (i <- range) {
    println(i)
  }
}
