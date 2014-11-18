object TraitExample{

  abstract class TraitMaster {
    def get(i:Int):Int = i
  }


  trait Level1 extends TraitMaster{
     override def get(i:Int): Int = super.get(i*2)
  }

  trait Level2 extends TraitMaster{
     override def get(i:Int): Int = super.get(i-1)
  }


  //method on the furthest to right is called first
  class F1 extends Level2 with Level1 {
    override def get(i:Int): Int = super.get(i)
  }

  val f1 = new F1()
  f1.get(2)


  class F2 extends Level1 with Level2 {
    override def get(i:Int): Int = super.get(i)
  }

  val f2 = new F2()
  f2.get(2)
}