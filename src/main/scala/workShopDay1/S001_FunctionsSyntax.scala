package workShopDay1

object S001_FunctionsSyntax extends App {
  // FunctionN -> N ranges from 0 to 22, N defines no of args to functions
  // compiler will convert function into functionN

  // Function with no args and no return type
  // Lambda => is another common way to create functions

  //Function0
  //With no args and no return type
  val show = new Function0[Unit] {
    def apply() : Unit = println("Hello")
  }
  //ways to call above function
  show()   // Scala compiler internally calls show.apply()
  show.apply()
  // With no args but returns value
  val version = new Function0[String] {
    def apply() : String = sys.props("java.version")
  }

  println(version)
  println(version.apply())

  // accepts 1 arg and returns square of number as output
  val power = new Function1[Int, Int]  {
    def apply(n: Int) : Int = n* n
  }

  println(power(5))

  // Accepts 2 args and returns sum as output
  // Function2 takes 2 input and returns one output
  val addNums =  new Function2[Int, Int, Int] {
    def apply (n1:Int, n2:Int) :Int = n1+n2
  }

  println(addNums(5,10))
}
