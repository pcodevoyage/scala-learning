package excercises

object P03kthElement {

	def nth[A](i:Int, l:List[A]) : A = {
	   if(i > 0) l(i)
	   else throw new NoSuchElementException
	}                                         //> nth: [A](i: Int, l: List[A])A
	
	def nthRecursive[A](i:Int, l:List[A]) : A = (i,l) match {
	 case (0,h :: _) => h
	 case (n,_ :: tail) => nthRecursive(n-1, tail)
	 case (_,Nil) => throw new NoSuchElementException
	}                                         //> nthRecursive: [A](i: Int, l: List[A])A
	
	
	nth(3, List(3,5,612,33,56))               //> res0: Int = 33
	
	nthRecursive(3,List(3,5,612,33,56))       //> res1: Int = 33
}