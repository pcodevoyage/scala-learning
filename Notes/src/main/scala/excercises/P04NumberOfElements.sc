package excercises

object P04NumberOfElements {

	def len[A](l:List[A]):Int = l match {
		case Nil => 0
		case x::Nil => 1
		case _ :: tail => 1 + len(tail)
		case _ => throw new Exception
	}                                         //> len: [A](l: List[A])Int
	
	len(List("this","is","nice"))             //> res0: Int = 3
	len(List())                               //> res1: Int = 0
}