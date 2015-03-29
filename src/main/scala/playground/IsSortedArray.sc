object IsSortedArray{

  def isSortedArray[A]( a:Array[A],gt:(A,A)=>Boolean):Boolean= {
    if (a.length<2) true
    if (gt(a(0),a(1))) false
    else isSortedArray(a.slice(1,a.length),gt)
  }

  isSortedArray(Array(1,12,3,4), (a:Int,b:Int)=> a>b)
  isSortedArray(Array(1,2,3,4,5), (a:Int,b:Int)=> a>b)
}