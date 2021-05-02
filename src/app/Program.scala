package app

import app.models.{AicWeatherUpdate, AirlineWeatherUpdate, AtcWeatherUpdate, DiContainer}
import com.rabbitmq.client.ConnectionFactory

import scala.io.StdIn.readLine

object Program extends App {

  val diContainer = setupDi()

  val factory = diContainer.connectionFactory
  val connection = factory.newConnection()
  val channel = connection.createChannel()
  val senders = diContainer.senders
  val enricher = diContainer.enricher
  val scheduler = diContainer.scheduler
  scheduler.start(300)
  readLine()

  private def setupDi(): DiContainer = {
    DiContainer(
      new ConnectionFactory() { setHost("localhost") },
      senders = List(
        MessageSender[AicWeatherUpdate](channel, "aic", new AicFilter, new AicTranslator),
        MessageSender[AtcWeatherUpdate](channel, "atc", new AtcFilter, new AtcTranslator),
        MessageSender[AirlineWeatherUpdate](channel, "sas", new AirlineFilter, new SasTranslator),
        MessageSender[AirlineWeatherUpdate](channel, "klm", new AirlineFilter, new KlmTranslator),
        MessageSender[AirlineWeatherUpdate](channel, "swa", new AirlineFilter, new XmlTranslator),
        MessageSender[AirlineWeatherUpdate](channel, "baw", new AirlineFilter, new XmlTranslator),
      ),
      Enricher("http://api.openweathermap.org/data/2.5/weather?zip=8260,dk&units=metric&appid=fb14f1139067845d2f30a3d147e7df89"),
      Scheduler(enricher, senders)
    )
  }
}
