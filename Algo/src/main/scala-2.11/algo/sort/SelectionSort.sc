import scala.collection.mutable.ListBuffer
object SelectionSortFunctional{
//  var b =  ListBuffer(4,6,1,3)
val b = ListBuffer(1,3,4,5,6,7)

//  val l = Seq.fill(10)(Random.nextDouble()).toList
//  def min1[A<:Comparable[A]](x:A,y:A):A = if(x.compareTo(y) >=0)  x else y
  def min1(x:Int,y:Int):Int = if(x <=y)  x else y
  def min(list: ListBuffer[Int],tmp:Int,count:Int):(Int,Int)= list match {
    case a if (a.size==0) => (count,tmp)
    case a  =>min(a.tail,min1(tmp,a.head),count+1)
  }
  min(b,Int.MaxValue,-1)
  min( ListBuffer[Int](6,4,3),Int.MaxValue,-1)
  min( ListBuffer[Int](4,6),Int.MaxValue,-1)
  def swap[A](list: ListBuffer[A],destinationIndex:Int,sourceIndex:Int) ={
    println(s"swap(1) $list $destinationIndex $sourceIndex")

    val tmp = list(destinationIndex)
    list(destinationIndex)=list(sourceIndex)
    list(sourceIndex)=tmp
    println(s"swap(2) $list")
    list
  }
  def selectionSort(list:ListBuffer[Int]) : ListBuffer[Int] = list match {
    case a if (a.size <=1 )=> a
    case a => {
      val minIndex = min(a.tail,Int.MaxValue,-1)
      val newList=swap(a,0,a.indexOf(minIndex._2))
      println(s"$a - $minIndex-$newList")
      val g =selectionSort(newList.tail)
      g.prepend(newList.head)
      println(g)
      g





//      val newList =
//        if(minIndex > 0)swap(a,0,minIndex) else a.tail
//
//      val h = if(minIndex > 0)newList.head else a.head
//      val next =selectionSort(newList.tail,newList)
//      next.prepend(h)
//      println(s"$minIndex --- $next ---- $newList")
//      next
    }
  }
 val f = selectionSort(b)
  f
//  val m = min(b,Int.MaxValue,-1)
//  b.indexOf(m)
}