package app

import app.models.CanonicalWeatherUpdate
import com.rabbitmq.client.Channel

case class MessageSender[T](channel: Channel, queueName: String, filter: Filter[T], translator: Translator[T, _]) {
  def send(message: CanonicalWeatherUpdate): Unit = {
    val filteredMessage = filter(message)
    val translatedMessage = translator(filteredMessage)
    val serializedMessage = Serializer.serialize(translatedMessage)
    channel.queueDeclare(queueName, false, false, false, null)
    channel.basicPublish("", queueName, null, serializedMessage)
  }
}
