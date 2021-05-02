import models.{AicWeatherUpdate, CanonicalWeatherUpdate}

class AicFilter extends Filter [AicWeatherUpdate]{
  override def apply(update: CanonicalWeatherUpdate): AicWeatherUpdate = {
    AicWeatherUpdate(
      update.temperature,
      update.visibility,
      update.sunrise,
      update.sunset,
      update.country,
      update.cityName
    )
  }
}
