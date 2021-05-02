package models

import java.time.LocalDateTime
import java.util.Date

case class AicWeatherUpdate (
  temperature: Float,
  visibility: Int,
  sunrise: Date,
  sunset: Date,
  country: String,
  cityName: String,
) {

}
