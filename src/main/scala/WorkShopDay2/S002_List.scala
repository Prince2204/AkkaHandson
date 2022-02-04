package WorkShopDay2

object S002_List extends App {

  val products =  List("iPhone", "Vivo","Galaxy")
  products.foreach(println)
  println("--------------")
  println("Size of list: ", products.size)
  println("Head of List: ", products.head)
  println("Tail of List: ", products.tail)

  if (products.contains("Vivo F51"))
    println(" Product found")
  else
    println("Product Not Found")

  if (products.isEmpty)
    println("List is empty")
  else
    println("List s having elements")

  // Concatenation of list
  val products2 =  List("RealMe", "Mi","Google")
  // ::: -> concat two list
  val allProds = products:::products2
  println("------------------")
  allProds.foreach(println)
  println(allProds)
  // :: -> adding elements to another list
  val product3 = "Nokia" :: products
  println(product3)
}
