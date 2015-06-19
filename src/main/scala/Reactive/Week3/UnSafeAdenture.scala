package Reactive.Week3

/**
 * Created on 16/05/2015.
 */

object UnSafeAdenture{
  def apply():UnSafeAdenture = new UnSafeAdenture {
    override var eatenByMonster: Boolean = true
    override var treasureCost: Int = 42
  }
}

trait UnSafeAdenture{
  
  var eatenByMonster:Boolean 
  var treasureCost :Int

  //No indication that exception can be thrown
  def collectContainers():List[Coin]={
    if(eatenByMonster) throw new GameOver("Eaten by monster")
    
    List(Gold,Gold,Silver,Bronze)
  }
  
  def buyTeasure(coins:List[Coin]):Treasure ={
    if(coins.map(x=>x.value).sum < treasureCost)
      throw new GameOver("lack of fund")
    new Diamond()
  }


  def play():Unit={
    val adventure = UnSafeAdenture()


    // will fail if exception is thrown.
    val coins = adventure.collectContainers()

    val treasure = adventure.buyTeasure(coins)
  }
  
}

