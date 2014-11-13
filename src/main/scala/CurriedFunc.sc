object CurriedFunc{

  def add(x:Int,y:Int) = x+y
  add(4,5)

  //Method 1
  def addC(x:Int) = (y:Int) => x+y
  addC(4)(5)

  //Method 2
  def addC2(x:Int)(y:Int) = x+y
  addC2(4)(5)

  //Reverse
  val addC2Uncurried = Function.uncurried(addC2 _)
  addC2Uncurried(4,5)

  //Method 3
  def addM(a:Int,b:Int,c:Int) = a + b + c
  def addM1 = addM(4,_:Int,_:Int)

  addM1(1,2)
}