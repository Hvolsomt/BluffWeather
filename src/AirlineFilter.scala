import models.{AirlineWeatherUpdate, CanonicalWeatherUpdate}

class AirlineFilter extends Filter[AirlineWeatherUpdate] {
  override def apply(update: CanonicalWeatherUpdate): AirlineWeatherUpdate = {
    AirlineWeatherUpdate(
      update.cityName,
      update.country,
      update.temperature,
      update.clouds
    )
  }
}
