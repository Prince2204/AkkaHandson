package workShopDay1

object S001_Currying_closure extends App {
  // Curry Func -  A func that returns another function
  // Closure - A variable/parameter value, whose life exists even after the function call is complete

  //Seq Generator to generate a seq based on starting value and the step
  val seq = (start: Int, step: Int) => {
    // currVal is closure here as the value is remained in memory even after function call exited
    // visibility, since the currVal is referenced in generator and generator function returned
    // back to called
    var currVal = start

    val generator = () => {
      println("generator called")
      val presentValue = currVal
      currVal += step
      presentValue  //return value
    }
    generator  // we are returning a function
  }

  // call above created function
  val seq1By2 = seq(1,2)

  val seq100By10 = seq(100,10)

  println(seq1By2())
  println(seq1By2())
  println(seq1By2())

  println(seq100By10())
  println(seq100By10())
  println(seq100By10())
}
