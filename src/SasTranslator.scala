import models.AirlineWeatherUpdate
import models.messages.SasWeatherMessage

class SasTranslator extends Translator[AirlineWeatherUpdate, SasWeatherMessage]{
  override def apply(input: AirlineWeatherUpdate): SasWeatherMessage = {
    SasWeatherMessage(
      input.cityName,
      input.country,
      input.temperature,
      input.clouds
    )
  }
}
