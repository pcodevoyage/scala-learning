//P20 (*) Remove the Kth element from a list.
//Return the list and the removed element in a Tuple. Elements are numbered from 0.
//Example:
//
//  scala> removeAt(1, List('a, 'b, 'c, 'd))
//res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)


def removeAt(i:Int, l:List[Int]) = (l.take(i) ::: l.drop(l.length - i),l(i))


removeAt(3,List(1,2,3,4,5,6,7))