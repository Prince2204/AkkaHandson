package WorkShopDay2

object S002_ParameterGroup extends App {
  // Scala generated curry function to reuse parameters, results etc
  // Normal Function without parameter group
  def add(a: Int, b: Int, c: Int) = a + b + c

  println("add 1, 2, 3: " + add(1, 2, 3))

  // Sum function has two nested curry functions inside parameter group
  def sum(a: Int)(b: Int)(c: Int) = a + b + c

  // sum is a method not a function. Parameter group works with functions
  // Method is converted to a function using method_name and appended by underscore
  val sumF = sum _
  val sum10 = sumF(10) // it will pass a as 10, and returns a curry function that accepts  b as parameter
  val sum10Plus20 = sum10(20) //b = 20 & returns a curry function that accepts c as parameter
  val result = sum10Plus20(20) //c = 30, this returns a+b+c =  60

  println("Result is :" + result)
  println("Result 1 is :" + sum10Plus20(40))

  // s"" - It is called template string, useful to substitute values
  def heading(parent: String)(header: String)(title: String)
  = s"<$parent><$header>$title</$header></$parent>"

  //
  val h1 = (heading _) ("div")("h1")
  val h2 = (heading _) ("div")("h2")

  println(h1("Welcome to Deloitte"))

  println(h2("Welcome to Scala Training"))

}
