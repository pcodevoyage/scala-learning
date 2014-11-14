import helper.{PreferedLang, GreetClass}
object ImplicitExample{
  //Rules
  //1. Only definitions marked implicit are available
  //2. Implicit definition must be in scope.
  //When compile once fails to make a conversion. It will look for an implicit def.
  //This will be done only once.
  implicit def doubleToInt(x:Double)= x.toInt
  val i:Int = 4.5
  implicit val p = new PreferedLang("Hindi")
  GreetClass.greet("Hello")(p)
  //no need for the second parameter
  GreetClass.greet("This is awesome")
  def addFour(x:Int):Int = x+4
  def applyToAll(elements : List[Int], change:Int =>Int) : List[Int] =elements match {
    case List() => Nil
    case List(x) => change(x) :: Nil
    case x :: rest => change(x) :: applyToAll(rest,change)
  }
  applyToAll(List(1,1,1),addFour)


  def maxList[T](elements : List[T])(implicit orderer : T => Ordered[T]) : T = elements match {
    case List() => throw new IllegalArgumentException("empty list")
    case List(x) => x
    case x :: rest => {
      val maxRest = maxList(elements)(orderer)
      if(orderer(x) > maxRest) x
      else maxRest
    }
  }

//  maxList(List(4,1,-10,10))(Ordering.Int)
}

