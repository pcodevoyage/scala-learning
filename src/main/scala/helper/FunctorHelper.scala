package helper

trait Functor[F[_]] {
  /*
  For every element in fa apply f to change F[A] to F[B]
   */
  def fmap[A,B](fa:F[A])(f: =>B):F[B] => F[A]
}

//implicit object ListFunctor extends Functor[List] {
//  def fmap[A, B](f: A ⇒ B): List[A] ⇒ List[B]
//  = list ⇒ list map f
//}