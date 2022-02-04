package WorkShopDay2

object S002_Generic extends App {
  //Generic is Type safe, substitute subtype
  class Stack[T] {
    var elems: List[T]= Nil // Immutable list
    def push(x:T) = elems = x :: elems
    def top() = elems.head
    def pop() = elems = elems.tail
    def isEmpty() = elems.isEmpty
  }

  case class Car (id: String)
  // Stack of cars
  var cars: Stack[Car] =  new Stack
  val strings : Stack[String] = new Stack
  // add elements to stack cars
  cars.push(Car("12345"))
  cars.push(Car("23456"))
  println(cars.top())
  println(cars.elems)
  cars.pop()
  println(cars.elems)

}
