package app.models.messages

import java.time.LocalDateTime
import java.util.Date

case class AicWeatherMessage(
  temperature: Float,
  visibility: Int,
  sunrise: Date,
  sunset: Date,
  country: String,
  cityName: String
) {

}
