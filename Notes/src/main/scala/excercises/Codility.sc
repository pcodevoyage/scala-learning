

val a:Array[Int] = Array(1,3,4,5,6)
def f(a:Array[Int],i:Int):Int={
  a.drop(i).foldLeft(0)((a,b)=>a+b)
}

def f2(a:Array[Int],i:Int):Int={
  a.take(i).foldLeft(0)((a,b)=>a+b)
}

val i =3
val diff = f2(a,i) - f(a,i)
Math.abs(diff)
Int.MaxValue



val l = a.length

def fun(a:Array[Int],c:Int,min:Int):Int = (c,min) match {
  case (6,m) => m
  case (_,m) => {
    val tmp = Math.abs(a.drop(c).foldLeft(0)((a,b)=>a+b) - a.take(c).foldLeft(0)((a,b)=>a+b))
    print(tmp)
    if(tmp < m)
      fun(a,c+1,tmp)
    else
      fun(a,c+1,m)
  }
}


fun(a,0,Int.MaxValue)








def solution(A: Array[Int]): Int = {
  // write your code in Scala 2.10
  def fun(a:Array[Int],c:Int,min:Int, len:Int):Int = (c,min) match {
    case (len,m) if(len==a.length) => m
    case (_,m) => {
      val tmp = Math.abs(a.drop(c).foldLeft(0)((a,b)=>a+b) - a.take(c).foldLeft(0)((a,b)=>a+b))
      print(tmp)
      if(tmp < m)
        fun(a,c+1,tmp,len)
      else
        fun(a,c+1,m,len)
    }
  }
  fun(A,0,Int.MaxValue,A.length)
}

val A:Array[Int] = Array(3,1,2,4,3)
solution(A)




