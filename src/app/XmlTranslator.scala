package app

import app.models.AirlineWeatherUpdate

class XmlTranslator extends Translator[AirlineWeatherUpdate, String]{
  override def apply(input: AirlineWeatherUpdate): String = {
    throw new NotImplementedError()
  }
}
