object MethodInjection{
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

  def plus[A:Monoid[A]](a:A,b:A):A = implicitly[Monoid[A]].mappend(a,b)

  plus(3,4)
}