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
      //println(packed+" ------- " + next)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  val p = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  pack(p)

//  P10 (*) Run-length encoding of a list.
//    Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
//  Example:
//
//    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  val t = pack(p) map {e => (e.length,e.head)}




//  P11 (*) Modified run-length encoding.
//  Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
//  Example:
//
//    scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//  res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  pack(p) map {e =>
    if (e.length > 1) (e.length,e.head)
    else e.head
  }

  t map { l => if(l._1==1) l._2 else l}

  def typeSafe[Symbol](l : List[Symbol]) : List[Either[Symbol,(Int,Symbol)]] =
    t map{ l => if(l._1==1) Left(l._2) else Right(l)}

}