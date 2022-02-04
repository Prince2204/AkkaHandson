package WorkShopDay2
import scala.collection.mutable.ArrayBuffer

object S002_ArrayBuffer extends App {

  //Mutable array buffer
  val products: ArrayBuffer[String] = new ArrayBuffer[String]()

  // Add elements to arraybuffer
  products.addOne("Oppo")
  products += "Vivo"
  products.insert(0,"Mi")
  // Add multiple elements to arraybuffer
  val listOfProd =  Seq("Apple","Samsung","LG")
  products.addAll(listOfProd)

  products.foreach(println)
  println("-------")
  //Access elements using index
  println(products(0), products(1), products(5))
  println("-------")
  println(products(0))
  // Update existing value
  products.update(1,"Oppo F1")
  println("-------")
  println(products(1))
  // Remove element
  // Remove by using Index
  products.remove(3)
  // Remove by element name
  products -= "Oppo F1"
  println("-------")
  products.foreach(println)
 // Removing multiple elements at a time
  products.remove(1,2)
  println("-------")
  products.foreach(println)
  // Remove all elements
  products.clear()
  println("-------")
  println(products.length)
}
