//P18 (**) Extract a slice from a list.
//  Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
//Example:
//
//  scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: List[Symbol] = List('d, 'e, 'f, 'g)


val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

def slice[A](i:Int,j:Int,l:List[A]) : List[A] = l.zipWithIndex filter {
  d => d._2 >= i && d._2<j
} map {
  d => d._1
}

slice(3,7,l)

//-----------------------------------------------

l.slice(3,7)

//-----------------------------------------------



def sliceRecursive(i:Int,j:Int,l:List[Int]) : List[Int]={

  def slice(x:Int,ol:List[Int],acl:List[Int]) : List[Int] = (x,ol) match {
    case (_,Nil) => acl
    case (k,h::tail) if (k<=i || k>=j) => slice(x+1,tail,acl:+h)
    case (k,_::tail) if (k>i && k<j) => slice(x+1,tail,acl)
  }

  slice(1,l,List[Int]())
}

val m = List(1,2,3,4,5,6,7,8)
sliceRecursive(3,7,m)
sliceRecursive(3,7,List(1,3,4))
sliceRecursive(3,7,Nil)



def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
  def sliceR(count: Int, curList: List[A], result: List[A]): List[A] =
    (count, curList) match {
      case (_, Nil)                     => result.reverse
      case (c, h :: tail) if end <= c   => result.reverse
      case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
      case (c, _ :: tail)               => sliceR(c + 1, tail, result)
    }
  sliceR(0, ls, Nil)
}