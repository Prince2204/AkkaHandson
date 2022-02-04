package Example

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import akka.routing.{RoundRobinPool}

object AkkaRouterExample extends App {

  // MasterActor[Parent Actor], WorkerActor[Child Actor]
  // Master receive a job, forward to worker to get  the work done
  case class Job(name:String)
  case class StopWork()
  case class JobCompleted(msg:String)

  class MasterActor extends  Actor {
    println("Master Actor created")
    println("Master Actor path is : ", akka.serialization.Serialization.serializedActorPath(self))
    // A parent actor can create child actor
    // Creating child actor below:
    //val worker1 = context.actorOf(Props[WorkerActor],"worker1")
    // Creating 2 worker actors as child, which will be routed
    val router = context.actorOf(RoundRobinPool(3).props(Props[WorkerActor]))

    def receive = {
          //router forward/tell/ask will be send to one of the 3 workers mentioned above
      case job: Job => router.forward(job)
      case _ => println("Master actor default message")
    }
  }

  class WorkerActor extends  Actor {
    println("Worker Actor created")
    println("Worker Actor path is : ", akka.serialization.Serialization.serializedActorPath(self))
    def receive = {
      case job: Job => {
        println(s"Job received by worker ${akka.serialization.Serialization.serializedActorPath(self)} : ", job)
        sender().tell(JobCompleted(s"Done ${job.name}"),self)
      }
      case _ => println("Worker actor default message")
    }
  }

  val system = ActorSystem("MasterWorkerTraining")
  // Create master worker
  val masterActor = system.actorOf(Props[MasterActor],"master")
  // message is send to master and master forwarded it to worker
  masterActor.tell(Job("Print 100 pages"),null)
  masterActor.tell(Job("Print 101 pages"),null)
  masterActor.tell(Job("Print 102 pages"),null)
  masterActor.tell(Job("Print 103 pages"),null)
  masterActor.tell(Job("Print 104 pages"),null)


}
