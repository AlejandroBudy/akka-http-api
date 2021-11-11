package es.alejandrobudy.api.entry_point

import akka.http.scaladsl.server.Directives.{get, path}
import akka.http.scaladsl.server.Route
import es.alejandrobudy.api.entry_point.controller.UserGetController

object Routes {
  val all: Route = get {
    path("users")(UserGetController())
  }
}
