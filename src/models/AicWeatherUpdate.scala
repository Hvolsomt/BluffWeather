package models

import java.time.LocalDateTime

case class AicWeatherUpdate (
  cityName: String,
  country: String,
  temperature: Float,
  sunrise: LocalDateTime,
  sunset: LocalDateTime,
  visibility: String
) {

}
