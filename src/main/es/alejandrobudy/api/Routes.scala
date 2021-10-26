package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, path}

object Routes {

  private val body =
    """
      | {
      | "status": "ok"
      | }
      |""".stripMargin
  val all = get {
    path("status") {
      complete(HttpEntity(ContentTypes.`application/json`, body))
    }
  }
}
