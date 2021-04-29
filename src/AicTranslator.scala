import models.AicWeatherUpdate
import models.messages.AicWeatherMessage

class AicTranslator extends Translator[AicWeatherUpdate, AicWeatherMessage] {
  override def apply(input: AicWeatherUpdate): AicWeatherMessage = {
    AicWeatherMessage(
      input.cityName,
      input.country,
      input.temperature,
      input.sunrise,
      input.sunset,
      input.visibility
    )
  }
}
