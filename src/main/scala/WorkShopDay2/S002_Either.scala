package WorkShopDay2

object S002_Either extends App {
  // Options gives us some value or None (we don't get error)
  // Either[Left, right], conventionally left means error side and right means correct side
  def safeDiv(a:Int, b:Int): Either[String, Int] = if (b!=0) Right(a/b) else Left ("Divide by Zero")

  val x = safeDiv(10,2)
  println(x, x.isRight, x.right.get, x.isLeft)

  if (x.isRight) {
    println("Correct result is : " +x.right.get)
  } else {
    println("Incorrect result is : " + x.left.get)
  }
  // for Comprehension for either
  // It resolves either, if right has data, it executes the block
  // if left has data, it doesn't execute [it assumes that wrong result]
  for{result <- x} {
    println("Result is: ", result)
  }
}
