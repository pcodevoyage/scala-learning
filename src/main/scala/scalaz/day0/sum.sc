object Sum{
  trait Monoid[A]{
    def mappend(a:A,b:A) : A
    def mzero:A
  }

  object IntMonoid extends Monoid[Int]{
    def mappend(a:Int,b:Int):Int = a + b
    def mzero:Int = 0
  }

  def sum[A](xs:List[A],m:Monoid[A]):A = xs.foldLeft(m.mzero)(m.mappend)


  val l = List(1,2,3,4,5)
  l.foldLeft(0)(_ + _)
  sum(l,IntMonoid)


}