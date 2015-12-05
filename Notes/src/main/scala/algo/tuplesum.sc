import scala.util.Random

def gen(i:Int,l :List[Int]):List[Int] = i match {
  case 0 => l
  case x if x > 0 => {
    val r = new Random()
    gen(i-1,r.nextInt()::l)
  }
}

val l = gen(1000,List())
l(1)
def count(c:Int,l:List[Int]) : Int = l match {
  case Nil => c
  case j if j.length < 3 => c
  case j => {
    if(j(0)+j(1)+j(2)==10) count(c+1,j.tail)
    else count(c,j.tail)
  }
}

count(0,l)