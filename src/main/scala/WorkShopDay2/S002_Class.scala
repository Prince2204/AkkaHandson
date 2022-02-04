package WorkShopDay2

object S002_Class extends App {
  class Product (val id: Int, val name: String, var price: Double) {
    //default Constructor
    println("Product Created  $id $ name $price")
    //member function using def, written in java style
    def getPrice() = price  // returns price
    def setPrice(v: Double) = price = v  // sets price

    var grandTotal = 0.0
    def calculate () = {
      println("Discount Given is : "+discount)
      println(("MRP is :" +price))
      val discountedPrice = price - price*discount/100
      println(("Discounted Price is :" +discountedPrice))
      grandTotal =  discountedPrice + discountedPrice * .18
    }

    //scala style getter and setter
    private var _discount = 0.0
    //getter
    def discount =_discount
    //setter _ is overloaded , no space between _=
    def discount_= (value:Double) : Unit =_discount = value
  }

  val p1 = new Product(1, "iPhone 12", 50000.00)
  println(p1.id, p1.name, p1.price)
  p1.price = 55000.00
  println("After updating price: "+ p1.id, p1.name, p1.price)

  p1.calculate()
  println("grant total: "+p1.grandTotal)

  // calling discount getter
  println("discount is : "+ p1.discount)
  //set discount as 20%
  p1.discount = 20

  p1.calculate()
  println("grant total after discount and GST applied with 18% : "+p1.grandTotal)

 /* val p2 = new Product(2, "Prod2", 200.00)
  println(p2.id, p2.name, p2.price)*/

}
