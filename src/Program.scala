import com.rabbitmq.client.AMQP.Queue
import com.rabbitmq.client.{Channel, ConnectionFactory}
import models.messages.SasWeatherMessage
import models.{AicWeatherUpdate, AirlineWeatherUpdate, AtcWeatherUpdate}

import scala.io.StdIn.readLine

object Program {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection = factory.newConnection()
  val channel = connection.createChannel()
  val senders = List(
    MessageSender[AicWeatherUpdate](channel, "aic", new AicFilter, new AicTranslator),
    MessageSender[AtcWeatherUpdate](channel, "atc", new AtcFilter, new AtcTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "sas", new AirlineFilter, new SasTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "klm", new AirlineFilter, new KlmTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "swa", new AirlineFilter, new XmlTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "baw", new AirlineFilter, new XmlTranslator),
  )
  val enricher = new Enricher
  val scheduler = Scheduler(enricher, senders)
  scheduler.start(300)
  readLine()
}
