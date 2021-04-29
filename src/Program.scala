import com.rabbitmq.client.AMQP.Queue
import com.rabbitmq.client.{Channel, ConnectionFactory}

object Program {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection = factory.newConnection()
  val channel = connection.createChannel()
  val atcQueue = channel.queueDeclare("atc", false, false, false, null)
  val aicQueue = channel.queueDeclare("aic", false, false, false, null)
  val sasQueue = channel.queueDeclare("sas", false, false, false, null)
  val klmQueue = channel.queueDeclare("klm", false, false, false, null)
  val bawQueue = channel.queueDeclare("baw", false, false, false, null)
  val swaQueue = channel.queueDeclare("swa", false, false, false, null)
}
