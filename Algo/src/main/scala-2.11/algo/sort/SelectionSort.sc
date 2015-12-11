import scala.util.Random
object SelectionSort{
  val l = Seq.fill(10)(Random.nextDouble()).toList
  def min1(x:Double,y:Double) = if(x<y)  x else y
  def min(list: List[Double],tmp:Double):Double= list match {
    case Nil => tmp
    case x :: tail =>min(tail,min1(tmp,x))
  }
  def swap[A](list: List[A],i:Int,j:Int): Unit ={
  }
  val m = min(l,Double.MaxValue)
  l.indexOf(m)
}