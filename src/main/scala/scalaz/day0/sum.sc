object Sum {

  trait Monoid[A] {
    def mappend(a: A, b: A): A

    def mzero: A
  }

  object IntMonoid extends Monoid[Int] {
    def mappend(a: Int, b: Int): Int = a + b

    def mzero: Int = 0
  }

  def sum[A](xs: List[A], m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)


  val l = List(1, 2, 3, 4, 5)
  l.foldLeft(0)(_ + _)
  sum(l, IntMonoid)


  //  +++++++++++ Implicit version +++++++++

  //  implicit val intMonoid = IntMonoid
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

  def sumImp[A: Monoid](xs: List[A]): A = {
    val m = implicitly[Monoid[A]]
    xs.foldLeft(m.mzero)(m.mappend)
  }

  sumImp(l)
  sumImp("a"::"b"::"c"::Nil)
}