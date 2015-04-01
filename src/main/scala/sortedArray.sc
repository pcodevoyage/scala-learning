object sortedArray{

  def isSorted[A](a:Array[A],gt:(A,A)=>Boolean):Boolean={
    if (a.length<=1) true
    else if(gt(a(0),a(1))) false
    else isSorted(a.slice(1,a.length),gt)
  }

  val greater = (a:Int,b:Int)=>a>b

  isSorted(Array(),greater)

  isSorted(Array(1),greater)

  isSorted(Array(1,2,3,5),greater)

  isSorted(Array(1,2,14,1),greater)

  isSorted(Array(16,2,14,1),greater)




}