package excercises
object P07FlattenList {
  val eg=List(List(1, 1), 2, List(3, List(5, 8))) //> eg  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  def myFatten(l:List[Any]) : List[Any] = l flatMap {
  	case x:List[_] => myFatten(x)
  	case e => List(e)
  }                                               //> myFatten: (l: List[Any])List[Any]
  myFatten(eg)                                    //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)
}