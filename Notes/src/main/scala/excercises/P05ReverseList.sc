package excercises

object P05ReverseList {
  val eg:List[Int] = List(1, 1, 2, 3, 5, 8)       //> eg  : List[Int] = List(1, 1, 2, 3, 5, 8)
 	
  def reverse[A](l: List[A]): List[A] = l match {
    case Nil       => Nil
    case x  => rever(x,List[A]())
    case _         => throw new Exception
  }                                               //> reverse: [A](l: List[A])List[A]
  
  def rever[A](o:List[A],r:List[A]) : List[A] =(o,r) match{
  	case (Nil,d) => d
  	case (c,d) => rever(c.slice(0,c.length-1),d :+ c.last)
  }                                               //> rever: [A](o: List[A], r: List[A])List[A]
  
  reverse(eg)                                     //> res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  
  
  //---------------------------
  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse
                                                  //> reverseBuiltin: [A](ls: List[A])List[A]
  
  reverseBuiltin(eg)                              //> res1: List[Int] = List(8, 5, 3, 2, 1, 1)
  
  //----------------------------
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => System.out.println(h +": "+r);h :: r }
                                                  //> reverseFunctional: [A](ls: List[A])List[A]
  
  reverseFunctional(eg)                           //> 1: List()
                                                  //| 1: List(1)
                                                  //| 2: List(1, 1)
                                                  //| 3: List(2, 1, 1)
                                                  //| 5: List(3, 2, 1, 1)
                                                  //| 8: List(5, 3, 2, 1, 1)
                                                  //| res2: List[Int] = List(8, 5, 3, 2, 1, 1)
}