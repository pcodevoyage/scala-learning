package Reactive.Week2

/**
 * Created on 30/04/2015.
 */
trait Publisher {

  private var subscribers:Set[Subscriber] = Set()

  def subscribe(sub:Subscriber) = subscribers +=sub

  def unsubscribe(sub:Subscriber) = subscribers -=sub

  def publish() = subscribers foreach (_.handler(this))
}
