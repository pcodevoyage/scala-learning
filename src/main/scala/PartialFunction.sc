object PartialFunctionExample{
  //Function for all Int except 0
  def func: PartialFunction[Any,Int] = {
    case i:Int if i > 0 => i+1
    case i:Int if i < 0 => i -1
  }
  func(10)
  func(-10)
  //Will get scala.MatchError for following
  //func(0)
  //func("sdfsdf")
  func.isDefinedAt(0)
  val l = List(9,3,-1,0,"dsfdsf")
  //l map func - will get scala.MatchError
  //collect will do isDefinedAt first and then apply the function.
  //collect expects a partial function
  l collect func
  l collectFirst func
  l.lift(1) map ("Testing value " + _ ) getOrElse ""
  l.lift(10) map ("Testing value " + _ ) getOrElse ""
  def process[A](filter:A=>Boolean)(list:List[A]):List[A] = {
    lazy val recurse = process(filter) _

    list match {
      case head::tail => if (filter(head)) {
        head :: recurse(tail)
      } else {
        recurse(tail)
      }

      case Nil => Nil
    }
  }

  val even1 = (a:Int) => a%2 ==0
  val num = 1::2::3::4::5::Nil
  process(even1)(num)



  //- isDefined only works on level 1

  def funcList:PartialFunction[List[Int],String] = {
    case Nil => "One"
    case x :: y :: rest => "two"
  }

  funcList.isDefinedAt(List(1,2,3))

  def funcListTestLevel2:PartialFunction[List[Int],String] = {
    case Nil => "One"
    case x :: rest => rest match {
      case Nil => "two"
    }
  }
  //returns true even if we will get error
  funcListTestLevel2.isDefinedAt(List(1,2,3))
}