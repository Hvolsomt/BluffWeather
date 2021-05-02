import models.{AicWeatherUpdate, AtcWeatherUpdate}
import models.messages.{AicWeatherMessage, AtcWeatherMessage}

class AtcTranslator extends Translator[AtcWeatherUpdate, AtcWeatherMessage] {
  override def apply(input: AtcWeatherUpdate): AtcWeatherMessage = {
    AtcWeatherMessage(
      input.coordinate,
      input.temperature,
      input.pressure,
      input.humidity,
      input.visibility,
      input.wind,
      input.clouds,
      input.country,
      input.cityName
    )
  }
}
