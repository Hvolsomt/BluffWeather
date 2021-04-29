import models.{AicWeatherUpdate, AtcWeatherUpdate}
import models.messages.{AicWeatherMessage, AtcWeatherMessage}

class AtcTranslator extends Translator[AtcWeatherUpdate, AtcWeatherMessage] {
  override def apply(input: AtcWeatherUpdate): AtcWeatherMessage = {
    AtcWeatherMessage(
      input.cityName,
      input.coordinates,
      input.country,
      input.temperature,
      input.humidity,
      input.pressure,
      input.wind,
      input.clouds,
      input.visibility
    )
  }
}
