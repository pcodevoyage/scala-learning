object Fibo{

  // value -> 0 1 1 2 3 5
  // count -> 0 1 2 3 4 5
  def fibo(i:Int): Int = {
    if (i==0) return 0
    if (i==1) return 1
    else fibo(i-1) + fibo(i-2)
  }

  fibo(4)
  fibo(2)

  def fiboTail(i:Int, sum:Int =0) : Int = {
    if (i==0) return sum
    if (i==1) return sum
    else return fiboTail(i-1,sum+i-1)
  }

  fiboTail(4)
}