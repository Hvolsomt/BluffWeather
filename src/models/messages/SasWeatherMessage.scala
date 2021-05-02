package models.messages

case class SasWeatherMessage(
  temperature: Float,
  clouds: Int,
  country: String,
  cityName: String
)
