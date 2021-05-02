package app.models

import java.time.LocalDateTime
import java.util.Date

case class CanonicalWeatherUpdate(
  coordinate: Coordinate,
  temperature: Float,
  pressure: Int,
  humidity: Float,
  visibility: Int,
  wind: Wind,
  clouds: Int,
  country: String,
  sunrise: Date,
  sunset: Date,
  cityName: String
) {

}
