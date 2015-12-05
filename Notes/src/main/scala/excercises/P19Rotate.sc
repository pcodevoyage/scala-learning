//P19 (**) Rotate a list N places to the left.
//  Examples:
//  scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
//
//scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)



def rotateRecursive[A](i:Int,l:List[A]) : List[A]={

  def rotate(x:Int,ol:List[A],sl:List[A]) : (List[A],List[A]) = (x,ol) match {
    case ( _,Nil) => (Nil,Nil)
    case (x,h::tail) if (x<=i) => rotate(x+1,tail,sl:+h)
    case (x,_) if (x>i)=>(sl,ol)

  }

  var g = List[A]()

  val m =rotate(1,l,List[A]())
  m._2:::m._1
}

rotateRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))



def rotate[A](n: Int, ls: List[A]): List[A] = {
  val nBounded = if (ls.isEmpty) 0 else n % ls.length
  if (nBounded < 0) rotate(nBounded + ls.length, ls)
  else (ls drop nBounded) ::: (ls take nBounded)
}

rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))