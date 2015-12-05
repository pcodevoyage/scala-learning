import scala.None

object OptionExample{

  case class FriendlyNumber(i:Int)

  def getFriendlyNumber(i:Int) : Option[FriendlyNumber] = if (i%2 ==0) Some(new FriendlyNumber(i)) else None

  getFriendlyNumber(4) match {
    case Some(f) => "Yeah " + f
    case None => "Damn !"
  }

  val example = getFriendlyNumber(5).getOrElse("Will try something else")

  case class Coffee(coffee:String,milk:Option[String])

  val coffees = List(new Coffee("Black",None),
                     new Coffee("White",Some("full fat milk")),
                     new Coffee("Latte",Some("lots of milk")))


  val coffeeForMilkLover=coffees.filter( x => x.milk.isDefined)
}