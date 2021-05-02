package app

import app.models.AirlineWeatherUpdate

import java.io.StringWriter
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

class XmlTranslator extends Translator[AirlineWeatherUpdate, String]{
  override def apply(input: AirlineWeatherUpdate): String = {
    val context = JAXBContext.newInstance(classOf[AirlineWeatherUpdate])
    val marshaller = context.createMarshaller
    val writer = new StringWriter()
    marshaller.marshal(input, writer)
    writer.toString
  }
}
