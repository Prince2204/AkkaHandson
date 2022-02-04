package Example

import Example.AkkaParentChildExample.{Job, MasterActor}
import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
import akka.persistence._

object AkkaPersistentExample extends App {

  // How forward works
  // Supervisor

  // MasterActor[Parent Actor], WorkerActor[Child Actor]
  // Master receive a job, forward to worker to get  the work done
  case class Job(name:String)
  case class StopWork()
  case class JobCompleted(msg:String)

  case class State(count:Int)

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

  // How to make worker actor as persisted, so that if we restart it maintains/retains
  class WorkerActor extends  PersistentActor {
    println("Worker Actor created")
    println("Worker Actor path is : ", akka.serialization.Serialization.serializedActorPath(self))

    //persistentId is uniqueID, which should be used to store and retrieve state
    override def persistenceId: String = "worker-actor-state"

    //initialize the state so that initial value will be set
    var state:State = State(count = 0)

    override def receive = {
      case job: Job => {
        println("Job received by worker", job)
        //Increase the state counter by 1
        state = State(count = state.count+1)
        //Persist it
        //whenever there is a state change, we should persist state
        // the state object data shall be serialized and then it will be saved
        saveSnapshot(state)
        println("Total job done is: ", state.count)

        sender().tell(JobCompleted(s"Done ${job.name}"),self)
      }
      case t:Object => println("Worker actor default message: ", t)
    }
    //when akka goes into recovery mode, we have few messages sent by system
    // to full the data from snapshot and recover the data/state
    val receiveRecover : Receive = {
          //MESSAGES sent here for snapshot recovery, completion notification
      case SnapshotOffer(metadata,snapshot:State) => {
        println("Now snapshot given from Akka persistence to Actor: ", snapshot)
        //initialize akka state from snapshot
        state = snapshot
      }

      case RecoveryCompleted => {
        println("Recovery completed")
      }
      case _ => println("hello inside receiveRecover ")
    }
    // PersistentActor on normal operations
    val receiveCommand : Receive = {
      case _ => println("hello ! in receive command ")
    }
  }

  val system = ActorSystem("MasterWorkerTraining")
  // Create master worker
  val masterActor = system.actorOf(Props[MasterActor],"master")
  // message is send to master and master forwarded it to worker
  masterActor.tell(Job("Print 100 pages"),null)
  masterActor.tell(Job("Print 200 pages"),null)
  masterActor.tell(Job("Print 300 pages"),null)
  masterActor.tell(Job("Print 400 pages"),null)


}
