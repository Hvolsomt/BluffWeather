package models.messages

import java.time.LocalDateTime

case class AicWeatherMessage(
  cityName: String,
  country: String,
  temperature: Float,
  sunrise: LocalDateTime,
  sunset: LocalDateTime,
  visibility: String
) {

}
