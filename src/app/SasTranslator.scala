package app

import app.models.AirlineWeatherUpdate
import app.models.messages.SasWeatherMessage

class SasTranslator extends Translator[AirlineWeatherUpdate, SasWeatherMessage] {
  override def apply(input: AirlineWeatherUpdate): SasWeatherMessage = {
    SasWeatherMessage(
      input.temperature,
      input.clouds,
      input.country,
      input.cityName
    )
  }
}
