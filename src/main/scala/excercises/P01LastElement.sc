package excercises

object LastElement {
 //find the last element of a list
 
 def last(l:List[Int]):Int = l match {
 	case x :: Nil => x
 	case _ :: tail => last(tail)
 	case _ => throw new Exception("some thing bad happend")
 }                                                //> last: (l: List[Int])Int
 
 last(List(1,2,3,4,5,6,7))                        //> res0: Int = 7
}