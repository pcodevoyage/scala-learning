import scala.util.{Failure, Success, Try}

object TryExample{


  def func(num:Int,den:Int)= Try(num/den) match {

    case Success(i:Int) => "Ans "+i
    case Failure(_) => "Cannot do this"
  }


  func(4,2)
  func(4,0)
}