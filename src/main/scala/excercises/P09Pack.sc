//P09 (**) Pack consecutive duplicates of list elements into sublists.
//  If a list contains repeated elements they should be placed in separate sublists.
//  Example:
//
//  scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
object P09Pack{

  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span { _ == ls.head }
//      println(packed+" ------- " + next)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  val p =List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  pack(p)
//  pack(p) map (e => (e.length,e.head))
//  pack[Symbol](p).foldRight(List[Symbol]())(x=>x)
}