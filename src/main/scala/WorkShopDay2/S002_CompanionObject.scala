package WorkShopDay2

object S002_CompanionObject extends App {
  // When class name and Object name are same in same scala file, then object is called companion object

  class Brand (val id: Int, val name: String) {
    println ("Brand created $id $name")
  }
  // Normally we create object using new keyword
  // new keyword is not an expression, it is not functional
  val b1 = new Brand(1, "Apple")

  // Using companion object , object creation is like functional
  // 1. Create object using apply function
  // 2. Extract data out of object
  object Brand {
    def apply (id:Int, name: String) = new Brand (id, name)
  }

  // b2 is created using companion object. new keyword is not required here
  val b2 = Brand(2, "Samsung")

  println(b1.name)
  println(b2.name)

}
