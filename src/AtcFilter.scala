import models.{AtcWeatherUpdate, CanonicalWeatherUpdate}

class AtcFilter extends Filter[AtcWeatherUpdate] {
  override def apply(update: CanonicalWeatherUpdate): AtcWeatherUpdate = {
    AtcWeatherUpdate (
      update.cityName,
      update.coordinates,
      update.country,
      update.temperature,
      update.humidity,
      update.pressure,
      update.wind,
      update.clouds,
      update.visibility
    )
  }
}
