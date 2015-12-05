object MonoidsExample {

  /*Monoids Law:
  Set S with operation * is Monoid if
  Associative : a * ( b * c) = (a * b) * c
  Identity : There exists e in S such that e * a = a * e = a
   */
  trait Monoid[T] {
    def zero: T

    def operation(a: T, b: T): T
  }
  var stringMonoid = new Monoid[String] {
    def zero = ""
    def operation(a: String, b: String) = a + b
  }

  val stringList = List("this", "is", "monoid")

  stringList.foldRight(stringMonoid.zero)(stringMonoid.operation)


  // +++++++++++++ Next Example ++++++++++++++++++
  trait Monoid2[A] {
    def mappend(a1: A, a2: A): A

    def mzero: A
  }

  object Monoid2 {
    implicit val IntMonoid: Monoid2[Int] = new Monoid2[Int] {
      def mappend(a: Int, b: Int): Int = a + b

      def mzero: Int = 0
    }
    implicit val StringMonoid: Monoid2[String] = new Monoid2[String] {
      def mappend(a: String, b: String): String = a + b

      def mzero: String = ""
    }
  }

  def sum[A: Monoid2](xs: List[A]): A = {
    val m = implicitly[Monoid2[A]]
    xs.foldLeft(m.mzero)(m.mappend)
  }
  sum(List("a", "b", "c"))

  
}
