object P14Duplicate{

//  P14 (*) Duplicate the elements of a list.
//    Example:
//    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
//  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  def dublicate[A](l :List[A]):List[A] = l flatMap{j => j::j::Nil}

  dublicate(List('a, 'b, 'c, 'c, 'd))
  dublicate(List(1,4,12,43))


//  15 (**) Duplicate the elements of a list a given number of times.
//  Example:
//    scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
//  res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

  def repeat[A](i:Int,a:A):List[A]={
    if (i==0) Nil
    else a :: repeat(i-1,a)
  }

  def dulicateNtimes[A](n:Int,l:List[A]):List[A] = l flatMap (l=>repeat(n,l))

  dulicateNtimes(4,List('a, 'b, 'c, 'c, 'd))
  dulicateNtimes(3,List(1,4,12,43))

}