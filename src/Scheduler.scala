import com.rabbitmq.client.AMQP.Queue

case class Scheduler (enricher: Enricher, senders: List[MessageSender[_]]) {
  def start(timeoutInSeconds: Int): Unit = {
    def onTimeout = {
      val weatherUpdate = enricher.enrich
      senders.map(s => s.send(weatherUpdate))
    }
    Timer(timeoutInSeconds * 1000)(onTimeout)
  }
}
