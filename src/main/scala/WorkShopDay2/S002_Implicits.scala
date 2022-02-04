package WorkShopDay2

object S002_Implicits extends App {
  // Implicit - Compiler takes care of passing certain parameter values, calling conversion functions automatically
  // Implicits works based on scope, object, class or import scope

  {
    //example 1
    // Block scope
    // Below line will give error as we are trying to assign decimal to a variable of type integer
    // val d : Int = 45.5
    implicit def decToInt (v:Double) : Int = v.toInt
    val d : Int = 45.5 // compiler calls decToInt implicitly
  }

  {
    // second example
    class Config (val endPoint: String)

    def startServer(implicit config: Config) = {
      println("Starting server at: ", config.endPoint)
    }

    implicit val c = new Config ("http://localhost:8080")
    startServer // now config  is passed to startServer method automatically by compiler

  }

}
