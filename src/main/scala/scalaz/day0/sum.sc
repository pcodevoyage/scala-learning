object Sum{
  object IntMonoid {
    def mappend(a:Int,b:Int):Int = a + b
    def mzero:Int = 0
  }
  def sum(xs:List[Int]):Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)
  val l = List(1,2,3,4,5)
  l.foldLeft(0)(_ + _)
  sum(l)


}