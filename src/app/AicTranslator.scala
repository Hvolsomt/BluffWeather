package app

import app.models.AicWeatherUpdate
import app.models.messages.AicWeatherMessage

class AicTranslator extends Translator[AicWeatherUpdate, AicWeatherMessage] {
  override def apply(input: AicWeatherUpdate): AicWeatherMessage = {
    AicWeatherMessage(
      input.temperature,
      input.visibility,
      input.sunrise,
      input.sunset,
      input.country,
      input.cityName
    )
  }
}
