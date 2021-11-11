package es.alejandrobudy.api.entry_point

import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.http.scaladsl.server.Route
import es.alejandrobudy.api.module.user.domain.User

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
    path("users") {
      complete(users)
    }

  }
}
