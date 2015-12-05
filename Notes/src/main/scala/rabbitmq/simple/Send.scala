package rabbitmq.simple

import rabbitmq.MqHelper


/**
 * Created  on 12/03/15.
 */
object Send extends MqHelper{

  val QUEUE_NAME = "Apna"
  def main (args: Array[String]) {

    init()
    channel.queueDeclare(QUEUE_NAME, false, false, false, null)

    var i =10000
    while (i>0) {

      val msg: String = "Hello this is scala here   -> "+i
      //exchange - queue
      channel.basicPublish("", QUEUE_NAME, null, msg.getBytes)
      i=i-1
    }

    close()

  }
}
