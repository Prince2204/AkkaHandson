package workShopDay1

object S001_MatchCase extends App {
  // match case is an expression that returns an output
  val result = 13 % 2 match {
    case 0 => "Even"
    case 1 => "Odd"
    case _ => "Unknown"
  }

  println (result)
}
