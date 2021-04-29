package models.messages

case class AtcWeatherMessage(
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
