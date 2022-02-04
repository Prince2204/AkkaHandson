package workShopDay1

object S001_Methods_Arguements extends App {

  // Default Arguements

  def mul (a:Int, b: Int) :Int = a* b
  def add(a:Int, b:Int = 5): Int = a+b    // b= 5 is default value for arguement b is value is not passed
  println ("calling by passing both a and b :" + add(10, 20))
  println ("calling by passing only a :" + add(10))

  // Named Arguements
  println ("calling a named arguements for a and b :" + add(a =10, b =20))

  // Variable number of arguements
  def printAll(names: String *)  = {
    names.foreach(println)
  }

  println("checking PrintAll")
  printAll()
  printAll("Scala Tutorial")
  printAll("Prince","Shikha","Shivam")

  def sum(numbers: Int*): Any = {
    var r = 0
    for (n <- numbers) {
      r +=n
    }
    r  //return r
  }

  println(" Checking sum")
  println("sum without passing any number" +sum())  // number is empty
  println("sum by passing 1 number" +sum(10))  // number is empty
  println("sum by passing  3 number" + sum(10,20,30))  // number is empty
}
