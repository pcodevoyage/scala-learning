package rabbitmq.direct

import rabbitmq.MqHelper

/**
 * Created on 14/03/15.
 */
object SendDirect extends MqHelper{

  val EXCHANGE_NAME = "apna_direct"



  def main(args: Array[String]) {
    init()
    channel.exchangeDeclare(EXCHANGE_NAME,"direct")

    val msg:String = "this is a message to direct line with "

    var i = 10
    val keys:List[String] = List("debug", "error","info","warn")

    val r = scala.util.Random


    while (i>0) {
      val routingKey = keys(r.nextInt(100)%4)
      channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes)
      println("Sent ->> (" + routingKey + ")  " + msg + " ------- " + routingKey)
      i=i-1
    }

    close()
  }
}
