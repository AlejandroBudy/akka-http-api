package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import es.alejandrobudy.api.UserMarshaller._

object Routes {

  private val body =
    """
      | {
      | "status": "ok"
      | }
      |""".stripMargin

  private val users = Seq(
    User("1", "Alejandro"),
    User("2", "Budy")
  )
  val all = get {
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
