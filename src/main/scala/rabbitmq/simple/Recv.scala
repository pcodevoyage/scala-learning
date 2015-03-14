package rabbitmq.simple

import com.rabbitmq.client.QueueingConsumer
import rabbitmq.MqHelper

/**
 * Created on 12/03/15.
 */
object Recv extends MqHelper{

  val QUEUE_NAME="Apna"

  def main (args: Array[String]) {
    init()

    channel.queueDeclare(QUEUE_NAME, false, false, false, null)
    println(" [*] Waiting for messages. To exit press CTRL+C")

    val consumer = new QueueingConsumer(channel)
    channel.basicConsume(QUEUE_NAME, true, consumer)

    while (true) {
      val delivery = consumer.nextDelivery()
      val message = new String(delivery.getBody())
      println(" [x] Received '" + message + "'")
    }
  }

}
