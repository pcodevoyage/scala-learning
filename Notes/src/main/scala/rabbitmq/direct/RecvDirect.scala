package rabbitmq.direct

import com.rabbitmq.client.QueueingConsumer
import rabbitmq.MqHelper
import rabbitmq.simple.Recv._

/**
 * Created on 14/03/15.
 */
object RecvDirect extends MqHelper{

  def main(args: Array[String]) {
    init()

    channel.exchangeDeclare(SendDirect.EXCHANGE_NAME,"direct")

    val queueName = channel.queueDeclare().getQueue

    args foreach { routekey =>
      channel.queueBind(queueName,SendDirect.EXCHANGE_NAME,routekey)
    }

    val consumer = new QueueingConsumer(channel)
    channel.basicConsume(queueName, true, consumer)

    while (true) {
      val delivery = consumer.nextDelivery()
      val message = new String(delivery.getBody())
      val routekey = delivery.getEnvelope.getRoutingKey
      println(" [x] Received '" + message + "'" + " ---- "+routekey)
    }

    close()
  }
}
