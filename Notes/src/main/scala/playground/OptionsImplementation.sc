￼def map2[A,B,C](a: Option[A], b: Option[B])(f: (A,B)=>C):Option[C] = (a,b) match{
  case (None,None) => None
  case (Some(a),None) => f(a,b)
}