package models

case class AirlineWeatherUpdate(
  temperature: Float,
  clouds: Int,
  country: String,
  cityName: String
) {

}
