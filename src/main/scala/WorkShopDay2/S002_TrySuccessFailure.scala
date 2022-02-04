package WorkShopDay2

import scala.util.{Try, Success, Failure}

object S002_TrySuccessFailure extends App {
  // These are helper utility to simplify try catch
  // Try and return success if no error else return failure
  def safeDiv(a:Int, b:Int) = Try(a/b)

  val x = safeDiv(10,2)
  println("x: ", x)
  if(x.isSuccess) println("value in X is: ",x.get)

  val y = safeDiv(10,0)
  println("y: ", y)
  if(y.isFailure) {
    println("Failed",y.failed)
  }
  // For comprehension for success part
  for{result <- x} {
    println(" Result in for comprehension= ", result)
  }

  // For comprehension for error part. The print statement will not execute
  for{result <- y} {
    println(" Result in for comprehension= ", result)
  }
}
