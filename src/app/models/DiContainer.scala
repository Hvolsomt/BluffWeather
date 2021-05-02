package app.models

import app.{Enricher, MessageSender, Scheduler}
import com.rabbitmq.client.ConnectionFactory

case class DiContainer(
  connectionFactory: ConnectionFactory,
  senders: List[MessageSender[_]],
  enricher: Enricher,
  scheduler: Scheduler
)
