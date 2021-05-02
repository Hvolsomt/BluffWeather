package app.models.messages

import app.models.{Coordinate, Wind}

case class AtcWeatherMessage(
  coordinates: Coordinate,
  temperature: Float,
  pressure: Int,
  humidity: Float,
  visibility: Int,
  wind: Wind,
  clouds: Int,
  country: String,
  cityName: String
)
