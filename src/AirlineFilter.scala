import models.{AirlineWeatherUpdate, CanonicalWeatherUpdate}

class AirlineFilter extends Filter[AirlineWeatherUpdate] {
  override def apply(update: CanonicalWeatherUpdate): AirlineWeatherUpdate = {
    AirlineWeatherUpdate(
      update.temperature,
      update.clouds,
      update.country,
        update.cityName,
    )
  }
}
