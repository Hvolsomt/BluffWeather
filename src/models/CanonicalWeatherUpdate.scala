package models

import java.time.LocalDateTime

class CanonicalWeatherUpdate (
  val cityName: String,
  val coordinates: String,
  val country: String,
  val temperature: Float,
  val humidity: Float,
  val sunrise: LocalDateTime,
  val sunset: LocalDateTime,
  val pressure: Float,
  val wind: Float,
  val clouds: String,
  val visibility: String
) {

}
