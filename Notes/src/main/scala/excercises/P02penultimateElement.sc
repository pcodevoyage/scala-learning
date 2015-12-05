package excercises

object penultimateElement {
  //find the second last element of the list
  
  def penultimate(l:List[Int]):Int = l match {
   case z :: _ :: Nil => z
   case _ :: tail => secondLast(tail)
   case _ => throw new Exception("Something bad happend")
  }
  
  penultimate(List(2,14,3,3,6,8,12))
}