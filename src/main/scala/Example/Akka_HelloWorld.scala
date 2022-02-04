package Example

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object Akka_HelloWorld extends App {
  //untyped actor
  class HelloActor extends Actor {
    println("Hello !! actor created")
    // actor path
    //       akka://training/user/hello_world#-1021153800
    // the path of actor can also be used to send messages
    println("Actor path is : ", akka.serialization.Serialization.serializedActorPath(self))
    //Every actor should have receive method
    // this function is called on every message
    // Dispatcher will call receive method
    def receive = {
          //handle tell messages
          // Sender represents who ask/send message
          // self is hello actor reference
          case "what is time now?" => sender().tell(System.nanoTime(),self)
          case msg: String => println("messsage is: ",msg)
          case _ => println("there is a message")
        // handle ask message
    }

    // life cycle method of Actors
    // preStart method is called when the actor is created, before starting the actor
    override def preStart(): Unit = {
      println("HelloActor PreStart method")
    }
    // postStop is called when actor is stopped
    // can be used to free up / release / clean resources
    override def postStop(): Unit = {
      println("HelloActor postStop method")
    }
    // Called when an actor crashed due to an exception and restarted after the error
    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      println("HelloActor preRestart method")
    }

    override def postRestart(reason: Throwable): Unit = {
      //to call base class
      super.postRestart(reason)
      println("HelloActor postRestart method")
    }

  }
  //Create Actor system.
  // Every actor system will have a name, in the path hierarchy
  val system = ActorSystem("training")
  // Create an Actor in System
  val helloActor = system.actorOf(Props[HelloActor], "hello_world")
  //Send a tell message to actor
  // Tell message means Fire and Forget. Don't wait for response
  // sender = null -> means not sending the reference of sender
  helloActor.tell("Hello Akka",null)
  // use ! to tell the message
  helloActor ! "Hello Scala"
  // Ask message, wait for response until timeout
  // Response can be sync or async
  implicit val timeout =  Timeout(5 seconds)
  // Future is required for ask call
  val future = ask(helloActor,"what is time now?")
  // For now blocking call is used, although it is not recommended
  // we wait for response, meanwhile the main thread waits
  val result =  Await.result((future), 2 seconds)
  println(("time is : ",result))
  //Non-Blocking call
  //Caller/Main thread will not be blocked
  // ask or ? can be used for ask message
  val future2 = helloActor ? "what is time now?"
  future2.onComplete {
    case Success(value) => println("time now is : ", value)
    case Failure(exception) => println("got exception", exception)
  }

  val future3 = Future {
    Thread.sleep(10000)
    // Option 1:
    // Stop method will call postStop Method
    /*println("stopping actor")
    system.stop(helloActor)*/
    // shutdown actor system
    //Option 2: by sending poisenPill message
    /*println("sending poisenPill message")
    helloActor ! PoisonPill*/
    // Option 3: When the whole actor system terminated
    println("shutdown actor system")
    system.terminate()
  }

}
