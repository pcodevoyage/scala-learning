object polymorphism{

  //parametric polymorphism
  def head[A](x:List[A]) : A =x(0)

  head(1::2::Nil)
  case class Dish(name:String)
  head(Dish("fish and chips") :: Dish("sushi")::Nil)

  //subtype polymorphism
  def plusDef[A <: Plus[A]](a1:A,a2:A):A = a1.plus(a2)

  val i1 = new IntPlus(3)
  val i2 = new IntPlus(4)
  //plusDef[IntPlus](i1,i2)
}

trait Plus[A]{
  def plus(a:A): A
}

class IntPlus(val a:Int) extends Plus[Int]{
  override def plus(b: Int): Int = this.a + b
}



