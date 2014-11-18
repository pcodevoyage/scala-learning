object ExtractorExample{

  FreeUser.unapply(new FreeUser("Joe"))

  val user: User = new PremiumUser("Daniel")
  user match {
    case FreeUser(name) => "Hello " + name
    case PremiumUser(name) => "Welcome back, dear " + name
  }



}
trait User{
  def name :String
}

class FreeUser(val name:String) extends User
class PremiumUser(val name:String) extends User
object FreeUser{
  def unapply(user:FreeUser):Option[String] = Some(user.name)
}

object PremiumUser{
  def unapply(user:PremiumUser):Option[String] = Some(user.name)
}



