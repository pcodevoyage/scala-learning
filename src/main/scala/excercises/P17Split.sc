val l = List(1, 2, 3, 4, 5, 6)

def funcSplitList[A](l: List[A], i: Int): List[List[A]] = l.take(i) :: l.drop(i) :: Nil

funcSplitList(l, 3)

def splitList[A](l: List[A], i: Int): List[A] = (i, l) match {
  case (0, _) => l
  case (_, Nil) => Nil
  case (x, h :: tail) => splitList(tail, x - 1)
}

splitList(l, 3)


//----------------------------------------------------------------------------------------

def recursive[A](l: List[A], i: Int): (List[A], List[A]) = (i, l) match {
  case (_, Nil) => (Nil, Nil)
  case (0, list) => (Nil, list)
  case (n, h :: tail) => {
    val (pre, post) = recursive(tail, i - 1)
    (h :: pre, post)
  }
}

recursive(l, 3)

//----------------------------------------------------------------------------------------


