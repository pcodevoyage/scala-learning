object P14Duplicate{

//  P14 (*) Duplicate the elements of a list.
//    Example:
//    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  def dublicate[A](l :List[A]):List[A] = l flatMap{j => j::j::Nil}

  dublicate(List('a, 'b, 'c, 'c, 'd))
  dublicate(List(1,4,12,43))

}