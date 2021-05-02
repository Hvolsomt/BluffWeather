package app

import app.models.{AicWeatherUpdate, AirlineWeatherUpdate, AtcWeatherUpdate, CanonicalWeatherUpdate}
import com.rabbitmq.client.ConnectionFactory

import scala.io.StdIn.readLine

object Program extends App {
  val scheduler = Scheduler(
    "localhost",
    "http://api.openweathermap.org/data/2.5/weather?zip=8260,dk&units=metric&appid=fb14f1139067845d2f30a3d147e7df89",
    s => printf(s.queueName)
  )
  scheduler.start(300)
  readLine()
}
