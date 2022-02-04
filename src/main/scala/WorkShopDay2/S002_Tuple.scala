package WorkShopDay2

object S002_Tuple extends App {
  // Collection of elements / pair of elements / related elements to represent facts
  // Tuple is immutable
  // In scala tuple can be created using (), TupleN, ->
  // Tuple has a type

  val tuple0:Unit = ()  // tuple with no elements, of type Unit
  val tuple1: Tuple1[Int]= Tuple1(10) // add extra , to represent tuple only for tuple 1
  println(tuple1._1)
  val tuple2 = ("iPhone",60000)
  // tuple members can be accessed using _1, _2
  println(tuple2._1,tuple2._2)

  val country = "India" -> "IND"
  println(country._1,country._2)


}
