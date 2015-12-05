object TupleExample{

  //Tuple are really mixed bags with some data put together
  //Tuple<number of elements> goes upto Tuple22
  val f = (23423,"dsfdsf")
  f._2

  val t:(Int,String) = f
  t._1

  val t1 = ("Al", 42, 200.0)
  t1.productIterator.foreach(println)

}