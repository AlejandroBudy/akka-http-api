package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import es.alejandrobudy.api.UserMarshaller._

object Routes {

  private val body =
    """
      | {
      | "status": "ok"
      | }
      |""".stripMargin

  private val users = Seq(
    User("73aec926-7840-4a44-87e0-2d540e37e636", "Alejandro"),
    User("73aec926-7840-4a44-87e0-2d540e37e636", "Budy")
  )
  val all: Route = get {
    path("status") {
      complete(HttpEntity(ContentTypes.`application/json`, body))
    } ~
      path("ping") {
        complete(HttpEntity(ContentTypes.`application/json`,
          """
            | {
            | "data": "pong"
            | }
            |""".stripMargin))
      } ~
      path("users") {
        complete(users)
      }

  }
}
