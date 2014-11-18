object MonoidsExample{

  /*Monoids Law:
  Set S with operation * is Monoid if
  Associative : a * ( b * c) = (a * b) * c
  Identity : There exists e in S such that e * a = a * e = a
   */

  trait Monoid[T] {
    def zero : T
    def operation(a : T, b : T) : T
  }


  var stringMonoid = new Monoid[String] {
    def zero = ""
    def operation(a:String,b:String) = a + b
  }


  val stringList = List("this","is","monoid")
  stringList.foldRight(stringMonoid.zero)(stringMonoid.operation)
}