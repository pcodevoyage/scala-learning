package rabbitmq

import com.rabbitmq.client
import com.rabbitmq.client.AMQP.Channel
import com.rabbitmq.client.ConnectionFactory

/**
 * Created on 12/03/15.
 */
trait MqHelper {

  val factory = new ConnectionFactory()
  val connection = factory.newConnection()
  val channel = connection.createChannel()

  def init()= {
    factory.setHost("localhost")
//    channel
  }

  def close(): Unit={
    channel.close()
    connection.close()
  }
}
