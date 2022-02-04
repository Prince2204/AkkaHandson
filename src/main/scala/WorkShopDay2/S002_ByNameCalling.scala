package WorkShopDay2

object S002_ByNameCalling extends App {
  //statement/expression/block as block of code
  // Method nano returns nao system time
  def nano(): Long = {
    println("Nano Called")
    System.nanoTime()
  }

  //t:=> Long , a block/expression that returns a long data value
  // t is not a value and is lazily executed only when used
  def delayed(t: => Long): Unit = {
    println("Delayed Called")
    t // this will cause the expression to be evaluated and executed
    println("After evaluating t: " + t)
  }

  // We expect nano to be called and return a long value, which will be passed as long value to method
  // delayed. But this is not true here
  delayed(nano())

  //passing expression that return long value
  delayed({
    println("expression called out")
    100 //return value
  })

}
