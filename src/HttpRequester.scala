import models.CanonicalWeatherUpdate
import org.json.{HTTP, JSONObject}

import java.net.URI
import java.net.http.{HttpClient, HttpRequest, HttpResponse}

object HttpRequester {
  def requestJson(webApi: String): JSONObject = {
    val request = HttpRequest.newBuilder()
      .uri(new URI(webApi))
      .GET()
      .build()

    val response = HttpClient.newBuilder()
      .followRedirects(HttpClient.Redirect.ALWAYS)
      .build()
      .send(request, HttpResponse.BodyHandlers.ofString())

    new JSONObject(response.body())
  }
}
