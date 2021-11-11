package es.alejandrobudy.api.entry_point

import akka.http.scaladsl.server.Directives.{get, path}
import akka.http.scaladsl.server.Route

final class Routes(val container: EntrypointDependencyContainer) {
  val all: Route = get {
    path("users")(container.userGetController())
  }
}
