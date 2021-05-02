package models

import java.util.Date

case class AtcWeatherUpdate(
  coordinate: Coordinate,
  temperature: Float,
  pressure: Int,
  humidity: Float,
  visibility: Int,
  wind: Wind,
  clouds: Int,
  country: String,
  cityName: String
)
