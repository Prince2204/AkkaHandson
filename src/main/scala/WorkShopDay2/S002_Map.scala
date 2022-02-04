package WorkShopDay2
import scala.collection.mutable.Map

object S002_Map extends App {

  val countries:Map[String ,String]= Map()
  // add elements
  countries += Tuple2("India", "IND")
  countries += ("United Kingdom" -> "UK")
  println(countries)

  println(countries.contains("India"))  // It should Print True
  countries.update("United Kingdom", "BR")
  println(countries)

  countries -= "United Kingdom"
  println(countries)
}

