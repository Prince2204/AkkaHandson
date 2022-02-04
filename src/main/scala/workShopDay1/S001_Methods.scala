package workShopDay1

object S001_Methods extends App {
  show()
  println(power(2))
  println(add(2,3))
  //Unit as return type
  def show() :Unit = {
    println ("Hello World")
  }
  def power(n:Int): Int = n * n
  def add (a: Int, b: Int) = {
    a + b
  }
}
