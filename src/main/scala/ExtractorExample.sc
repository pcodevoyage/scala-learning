object ExtractorExample{

//  FreeUser.unapply(new FreeUser("Joe"))
//
//  val user: User = new PremiumUser("Daniel")
//  user match {
//    case FreeUser(name) => "Hello " + name
//    case PremiumUser(name) => "Welcome back, dear " + name
//  }


  def checkUser(user:User1) =user match {
    case FreeUser1(name, _, p) =>
      if (p > 0.75 && p<0.9) name + ", what can we do for you today?"
    case PremiumUser1(name, _) => "Welcome back, dear " + name
    case fUser @ premiumCandidate() => "Oh yeah ! premiumCandidate" + fUser.name
  }

  val user1: User1 = new FreeUser1("Daniel", 3000,0.9d)
  checkUser(user1)
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

trait User1{
  def name :String
  def score:Int
}

class FreeUser1(val name:String,val score:Int, val upgradeProbability: Double) extends User1
class PremiumUser1(val name:String, val score:Int) extends User1

object FreeUser1{
  def unapply(user:FreeUser1):Option[(String,Int,Double)] = Some((user.name,user.score,user.upgradeProbability))
}

object PremiumUser1{
  def unapply(user:PremiumUser1):Option[(String,Int)] = Some((user.name,user.score))
}

object premiumCandidate {
  def unapply(user: FreeUser1): Boolean = user.upgradeProbability > 0.8
}