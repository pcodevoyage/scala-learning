package Reactive.Week3

/**
 * Created on 16/05/2015.
 */
class Coin(val value:Int)
case class Gold() extends Coin(200)
case class Silver() extends Coin(100)
case class Bronze() extends Coin(50)