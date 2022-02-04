package WorkShopDay2

object S002_Object extends App {
  //Object is an instance of a class.
  //Used to represent a static class as there is no static keyword in scala
  // Objects are singleton, only one instance
  object Logger {
    // Object body, shall be called to initialize object
    //invoked when object is used first time
    println("Logger Initialized")
    // Member variable of object
    var level = 0
    // Member function
    def debug (msg: String) = println("Log Level is:" +level + " and message is : "+msg)
  }
  //Using object for the first time
  Logger
  Logger.level = 1
  Logger.debug("App started")

}
