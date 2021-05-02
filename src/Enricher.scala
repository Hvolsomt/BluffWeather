import models.{CanonicalWeatherUpdate, Coordinate, Wind}
import org.json.JSONObject

import java.time.LocalDateTime
import java.util.Date

case class Enricher(webApi: String) {

def enrich: CanonicalWeatherUpdate = {
  val json = HttpRequester.requestJson(webApi)
  createWeatherUpdate(json)
}

  private def createWeatherUpdate(json: JSONObject): CanonicalWeatherUpdate = {
    val coord = json.getJSONObject("coord")
    val main = json.getJSONObject("main")
    val wind = json.getJSONObject("wind")
    val clouds = json.getJSONObject("clouds")
    val sys = json.getJSONObject("sys")

    CanonicalWeatherUpdate(
      coordinate = Coordinate(
        coord.getFloat("lon"),
        coord.getFloat("lat")
      ),
      temperature = main.getFloat("temp"),
      pressure = main.getInt("pressure"),
      humidity = main.getFloat("humidity"),
      visibility = json.getInt("visibility"),
      wind = Wind(
        wind.getFloat("speed"),
        wind.getInt("deg")
      ),
      clouds = clouds.getInt("all"),
      country = sys.getString("country"),
      sunrise = new Date(sys.getInt("sunrise")),
      sunset = new Date(sys.getInt("sunset")),
      cityName = json.getString("name")
    )
  }
}
