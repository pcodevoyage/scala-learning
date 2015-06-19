import scala.util.Random

//P20 (*) Remove the Kth element from a list.
//Return the list and the removed element in a Tuple. Elements are numbered from 0.
//Example:
//
//  scala> removeAt(1, List('a, 'b, 'c, 'd))
//res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)


def removeAt(i:Int, l:List[Int]) = (l.take(i) ::: l.drop(l.length - i),l(i))


removeAt(3,List(1,2,3,4,5,6,7))


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

def randomSelect(a:Int,l:List[Int]):List[Int] = (a,l) match {
  case (_,Nil) => Nil
    case(0,l) =>Nil
    case(x,l) => {
      val r = Random
      val res = (r.nextInt(l.length),l)
      res._1 :: randomSelect(x-1,res._2)
    }
}

randomSelect(3,List(1,2,3,4,5,6,7))
