package models.messages

case class SasWeatherMessage(
  cityName: String,
  country: String,
  temperature: Float,
  clouds: String
)
