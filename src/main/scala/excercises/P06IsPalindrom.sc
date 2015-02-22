package excercises

object P06IsPalindrom {

	val eg = List(1,2,3,2,1)                  //> eg  : List[Int] = List(1, 2, 3, 2, 1)
	val eg1 = List(1)                         //> eg1  : List[Int] = List(1)
	val eg2 = List(1,2,2)                     //> eg2  : List[Int] = List(1, 2, 2)
	val eg3 = List("this","is","this")        //> eg3  : List[String] = List(this, is, this)
	
	def isPalindrom[A](l:List[A]):Boolean = l match {
		case Nil => true
		case _ :: Nil => true
		case l if l.head == l.last => isPalindrom(l.slice(1, l.length-1))
		case _ => false
	}                                         //> isPalindrom: [A](l: List[A])Boolean
	
	isPalindrom(eg)                           //> res0: Boolean = true
	
	isPalindrom(eg1)                          //> res1: Boolean = true
	
	isPalindrom(eg3)                          //> res2: Boolean = true
	
	//------------------
	
	def inbuiltIsPalindrom[A](l:List[A]) : Boolean = l==l.reverse
                                                  //> inbuiltIsPalindrom: [A](l: List[A])Boolean
	
	inbuiltIsPalindrom(eg)                    //> res3: Boolean = true
}