//package excercises
object P08EliminateDuplicates {
  val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def compress[A](l:List[A],o:List[A]): List[A] = (l,o) match {
    case (x,Nil) => x
    case (x, h::tail) if (x.contains(h)) => compress(x,tail)
    case (x, h::tail) if (!x.contains(h)) => compress(h::x,tail)
  }
  compress(List[Symbol](),l)

  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if ( !r.contains(h)) h :: r
      else r
    }

  compressFunctional(l)
}