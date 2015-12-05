
val l1 = Some(2) :: Some(3) :: Some(4) :: Nil
val l2 = Some(2) :: Some(3) :: None :: Nil


def sequence[A](l:List[Option[A]]):Option[List[A]]= l match {
  case Nil => Some(Nil)
  case head::tail => head flatMap (hh => sequence(tail) map (hh::_))
}

sequence(l1)
sequence(l2)


def sequence2[A](l:List[Option[A]]):Option[List[A]] =
 l.foldRight(Some(Nil))((x,y)=>map2(x,y)(_::_))
