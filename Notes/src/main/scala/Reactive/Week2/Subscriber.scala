package Reactive.Week2

/**
 * Created on 30/04/2015.
 */
trait Subscriber {
  def handler(publisher: Publisher): Unit

}
