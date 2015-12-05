import scala.util.Random

//P20 (*) Remove the Kth element from a list.
//Return the list and the removed element in a Tuple. Elements are numbered from 0.
//Example:
//
//  scala> removeAt(1, List('a, 'b, 'c, 'd))
//res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)


def removeAt[A](i:Int, l:List[A]) = (l.take(i-1) ::: l.drop(i),l(i))

removeAt(4,List(1,2,3,4,5,6,7))


//P21 (*) Insert an element at a given position into a list.
//  Example:
//  scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

def insertAt[A](newElement:A,i:Int,l:List[A]):List[A]= l.take(i):::newElement::l.drop(i)
def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
  case (pre, post) => pre ::: e :: post
}

insertAt('new, 2, List('a, 'b, 'c, 'd))


//P22 (*) Create a list containing all integers within a given range.
//  Example:
//  scala> range(4, 9)
//res0: List[Int] = List(4, 5, 6, 7, 8, 9)

def range[A<:Int](a:A,b:A):List[Int]=(a,b) match{
  case(x,y) if (x==y) => List(y)
  case(x,y) if (x>y) => Nil
  case(x,y) if(x!=y)=> x :: range(x+1,y)
}

range(4,9)

//P23 (**) Extract a given number of randomly selected elements from a list.
//Example:
//  scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
//res0: List[Symbol] = List('e, 'd, 'a)

def randomSelect[A](a:Int,l:List[A]):List[A] = (a,l) match {
  case (_,Nil) => Nil
    case(0,l) =>Nil
    case(x,l) => {
      val r = Random.nextInt(l.length)
      val res = removeAt(r,l)
      res._2 :: randomSelect(x-1,res._1)
    }
}

randomSelect(3,List(1,2,3,4,5,6,7))


//P24 (*) Lotto: Draw N different random numbers from the set 1..M.
//  Example:
//  scala> lotto(6, 49)
//res0: List[Int] = List(23, 1, 17, 33, 21, 37)

def lotto(i:Int,m:Int):List[Int]= (i,m) match {
  case (0,_) => Nil
  case (x,y) => Random.nextInt(y) :: lotto(x-1,y)
}

lotto(6, 49)

//P25 (*) Generate a random permutation of the elements of a list.
//  Hint: Use the solution of problem P23.
//Example:
//
//  scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
//res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

def randomPermute[A](l:List[A]):List[A] = {
  def inner(i:Int):List[A]= i match {
    case 0 => Nil
    case x => randomSelect(1,l).head :: inner(x-1)
  }
  inner(l.length)
}
randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))