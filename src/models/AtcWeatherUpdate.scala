package models

import java.time.LocalDateTime

case class AtcWeatherUpdate
(
  cityName: String,
  coordinates: String,
  country: String,
  temperature: Float,
  humidity: Float,
  pressure: Float,
  wind: Float,
  clouds: String,
  visibility: String
)
{

}
