package excercises

object P05ReverseList {
  def reverse[A](l: List[A]): List[A] = l match {
    case Nil       => Nil
    case x  => rever(x,List[A]())
    case _         => throw new Exception
  }                                               //> reverse: [A](l: List[A])List[A]
  
  def rever[A](o:List[A],r:List[A]) : List[A] =(o,r) match{
  	case (Nil,d) => d
  	case (c,d) => rever(c.slice(0,c.length-1),d :+ c.last)
  }                                               //> rever: [A](o: List[A], r: List[A])List[A]
  
  reverse(List(1, 1, 2, 3, 5, 8))                 //> res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  
}