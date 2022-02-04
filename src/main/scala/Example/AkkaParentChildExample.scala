package Example

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object AkkaParentChildExample extends App {
  // How forward works
  // Supervisor

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
    val worker1 = context.actorOf(Props[WorkerActor],"worker1")

    def receive = {
      case job: Job => worker1.forward(job)
      case _ => println("Master actor default message")
    }
  }

  class WorkerActor extends  Actor {
    println("Worker Actor created")
    println("Worker Actor path is : ", akka.serialization.Serialization.serializedActorPath(self))
    def receive = {
      case job: Job => {
        println("Job received by worker", job)
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

  implicit val timeout = Timeout(5 seconds)
  // Now we are asking master, the master forwards the jo to worker
  // worker should respond back with answer Job Completed
  val future = ask(masterActor,Job("Are you able to print 200 pages?"))

  val result = Await.result(future, 2 seconds)
  println(("Result is :", result))
}
