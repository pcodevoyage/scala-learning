
object FoldLeftExample{
  trait Monoid[A] {
    def mappend(a: A, b: A): A

    def mzero: A
  }
  object Monoid {
    implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
      def mappend(a: Int, b: Int): Int = a + b

      def mzero: Int = 0
    }
    implicit val StringMonoid: Monoid[String] = new Monoid[String] {
      def mappend(a: String, b: String): String = a + b

      def mzero: String = ""
    }
  }
  object FoldLeftList{
    def foldLeft[A,B](xs:List[A],b:B,f:(B,A)=>B) =xs.foldLeft(b)(f)
  }
  def sum[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    FoldLeftList.foldLeft(xs,m.mzero,m.mappend)
  }
  val l = List(1, 2, 3, 4, 5)
  val lstr = List("a","b","c")
  l.foldLeft(0)(_ + _)
  sum(l)

  sum(lstr)
}