package app

import app.models.{AicWeatherUpdate, AirlineWeatherUpdate, AtcWeatherUpdate, CanonicalWeatherUpdate}
import com.rabbitmq.client.ConnectionFactory

case class Scheduler(hostName: String, weatherApiUrl: String, onUpdate: MessageSender[_] => Unit) {
  private val factory = new ConnectionFactory() {
    setHost(hostName)
  }
  private val connection = factory.newConnection()
  private val channel = connection.createChannel()
  private val enricher = Enricher(weatherApiUrl)
  private val senders = List(
    MessageSender[AicWeatherUpdate](channel, "aic", new AicFilter, new AicTranslator),
    MessageSender[AtcWeatherUpdate](channel, "atc", new AtcFilter, new AtcTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "sas", new AirlineFilter, new SasTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "klm", new AirlineFilter, new KlmTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "swa", new AirlineFilter, new XmlTranslator),
    MessageSender[AirlineWeatherUpdate](channel, "baw", new AirlineFilter, new XmlTranslator),
  )

  def start(timeoutInSeconds: Int): Unit = {
    def onTimeout: List[Unit] = {
      val weatherUpdate = enricher.enrich
      senders.map(
        s => {
          s.send(weatherUpdate)
          onUpdate(s)
        }
      )
    }

    Timer(timeoutInSeconds * 1000)(onTimeout)
  }
}
