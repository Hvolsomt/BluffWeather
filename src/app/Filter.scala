package app

import app.models.CanonicalWeatherUpdate

trait Filter[T] {
  def apply(update: CanonicalWeatherUpdate): T
}
