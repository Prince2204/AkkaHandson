package WorkShopDay3

import scala.concurrent.Future
import scala.util.{Failure, Success, Random}
import scala.concurrent.ExecutionContext.Implicits.global

//Threadpool is like pre created threads, which are kept idle until used

object S003_FutureBasics extends  App {

  val r = new Random()

  case class User(name: String)

  // E.g We will get user from DB, we use random num for example
  //if random is even, we get user , else we get exception
  def getUser() = {
    if (r.nextInt(1000) % 2 == 0)
      User("Krish")
    else throw new Exception("Ooh odd number, no user now")
  }

  println("Main thread Id", Thread.currentThread().getId)
  // the code in future block is executed inside thread pool
  val future = Future {
    Thread.sleep(3000)
    println("Future Worker Id", Thread.currentThread().getId)
    getUser()
  }

  // async, after future is executed, based on result, we will get a callback on complete
  future.onComplete {
    case Success(user) => println("yay!", user)
    // called when future completed with error / exception
    case Failure(exception) => println("On no!", exception)
  }

  println("Almost at end")
  Thread.sleep(10000)

}
