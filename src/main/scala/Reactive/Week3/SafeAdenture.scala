package Reactive.Week3

/**
 * Created on 16/05/2015.
 */
package Reactive.Week3

import scala.util.{Failure, Success, Try}

/**
 * Created on 16/05/2015.
 */

object SafeAdenture{
  def apply():SafeAdenture = new SafeAdenture {
    override var eatenByMonster: Boolean = true
    override var treasureCost: Int = 42
  }
}

trait SafeAdenture{

  var eatenByMonster:Boolean
  var treasureCost :Int

  //No indication that exception can be thrown
  def collectCoins():Try[List[Coin]]={
    if(eatenByMonster) throw new GameOver("Eaten by monster")

    Success(List(Gold,Gold,Silver,Bronze))
  }

  def buyTreasure(coins:List[Coin]):Try[Treasure] ={
    if(coins.map(x=>x.value).sum < treasureCost)
      throw new GameOver("lack of fund")
    Success(new Diamond())
  }


  def PlayI(): Unit = {
    val adventure = SafeAdenture()
    val coins: Try[List[Coin]] = adventure.collectCoins()
    val treasure: Try[Treasure] = coins match {
      case Success(cs)          => adventure.buyTreasure(cs)
      case Failure(t)           => Failure(t)
    }
  }

  //Use Flatten
  def PlayII(): Unit = {
    val adventure = SafeAdenture()
    val coins: Try[List[Coin]] = adventure.collectCoins()
    val treasure: Try[Treasure] = coins.flatMap(cs => adventure.buyTreasure(cs))
  }

  //Use For
  def PlayIII(): Unit = {
    val adventure = SafeAdenture()
    val treasure: Try[Treasure] = for {
      coins <- adventure.collectCoins()
      treasure <- buyTreasure(coins)
    } yield treasure
  }

}

