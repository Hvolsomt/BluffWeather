package app

import app.models.AirlineWeatherUpdate

class KlmTranslator extends Translator[AirlineWeatherUpdate, String] {
  override def apply(input: AirlineWeatherUpdate): String = {
    s"cityName = ${input.cityName}; " +
      s"country = ${input.country}; " +
      s"temperature = ${input.temperature}; " +
      s"clouds = ${input.clouds}; "
  }
}
