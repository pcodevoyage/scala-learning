object f {

  val f = List(1,3,4,25,100,150,200)
  
  f.map (x => x*2)

  def f1(x:Int) = if (x>2) Some(x) else None

  f map f1
  f.flatMap(x=>f1(x))

  f.map(f1)

  def f2(x:Int) = List(x-1,x,x+1)

  f map f2

  f.count(x => x > 0)
  f.filter(x=> x>99)
  f.filterNot(x => x > 99)
  f.head
  f.tail
  for(a <- f if a <99) yield a

  //nothing is returned
  f.foreach(x=> x*x)
  f.forall(x => x >0)

  val l = List(1,2,3)

  //Fold : cumulate results using a start value
  //fold(start value) z= accumulator; y=next number
  l.fold(2){ (z,y)=> 2*z-y}
  l.foldLeft(0){ (z,y)=> 2*z-y}
  l.foldRight(2){ (z,y)=> 2*z-y}

  //reduce : cumulate a single result
  l.reduce((a,b)=>2*a-b)

  //scan : get a collection apply start to all
  l.scan(1)((a,b)=>2*a-b)

  val filterList = List(234,11,34543,12,54,6,1,4,-1,-13123,-2,0,4)

  filterList.filter(_ % 2 == 0).sorted



}