import models.AirlineWeatherUpdate

class XmlTranslator extends Translator[AirlineWeatherUpdate, String]{
  override def apply(input: AirlineWeatherUpdate): String = {
    // To Xml
  }
}
