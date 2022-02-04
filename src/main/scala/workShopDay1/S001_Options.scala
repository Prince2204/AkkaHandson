package workShopDay1

object S001_Options extends App {

  def toInt (inp: String) = {
    try {
      inp.toInt
    } catch {
      case _ => 0
    }
  }

  val n = toInt("NAN")
  println(n)

  def toIntOptions (inp: String) : Option[Int] = {
    try {
      Some(inp.toInt)
    } catch {
      case _ => None
    }
  }

  val n1 = toIntOptions("Nan")
  println("n1 is :"+ n1)

  if (n1.isEmpty) println ("n1 has no data")

  val n2 = toIntOptions("50")
  println("n2 is :"+ n2)

  if (n2.isDefined) println ("n2 has some data")

  if (n2.isDefined) {
    val r = n2.get
    println("value in r is: "+r)
  }

  val data = List ("10","20","Nan","30")
  val goodData = List("1","2","3")

  goodData.map( i => toIntOptions(i))
  println("value in goodData is ")
  goodData.foreach(println)

  val result1 = goodData.map( i => toIntOptions(i))
    .map(opValue => opValue.get)
    .sum

  println("sum of good data numbers: "+ result1)

  data.map( i => toIntOptions(i))
  println("value in data is ")
  data.foreach(println)

  val result2 = data.map( i => toIntOptions(i))
    .filter(opValue => opValue.isDefined)
    .map(opValue => opValue.get)
    .sum

  println("sum of  data numbers: "+ result2)

  //val data1 = data.collect()
}
