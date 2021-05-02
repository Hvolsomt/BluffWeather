import models.{AtcWeatherUpdate, CanonicalWeatherUpdate}

class AtcFilter extends Filter[AtcWeatherUpdate] {
  override def apply(update: CanonicalWeatherUpdate): AtcWeatherUpdate = {
    AtcWeatherUpdate(
      update.coordinate,
      update.temperature,
      update.pressure,
      update.humidity,
      update.visibility,
      update.wind,
      update.clouds,
      update.country,
      update.cityName,
    )
  }
}
