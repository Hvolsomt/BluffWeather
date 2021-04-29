import models.{AicWeatherUpdate, CanonicalWeatherUpdate}

class AicFilter extends Filter [AicWeatherUpdate]{
  override def apply(update: CanonicalWeatherUpdate): AicWeatherUpdate = {
    AicWeatherUpdate(
      update.cityName,
      update.country,
      update.temperature,
      update.sunrise,
      update.sunset,
      update.visibility
    )
  }
}
