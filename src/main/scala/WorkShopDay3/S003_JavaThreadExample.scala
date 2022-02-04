package WorkShopDay3

import scala.util.control.Breaks._

class OrderProcessor extends Thread {
  override def run() {
    println("Worker Thread ", Thread.currentThread().getId)
    // runs forever
    breakable {
      while (true) {
        println("Long running queue");
        break;
      }
    }

    println("Done with thread");

  }
}

object S003_JavaThreadExample extends  App {

  println("Main Thread", Thread.currentThread().getId)
  val thread = new OrderProcessor()
  thread.start()
  // waits for the thread to finish
  println("waits for the thread to finish")
  thread.join()
}