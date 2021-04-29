import models.CanonicalWeatherUpdate

trait Filter[T] {
  def apply(update: CanonicalWeatherUpdate): T
}