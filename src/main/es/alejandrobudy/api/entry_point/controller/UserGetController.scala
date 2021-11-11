package es.alejandrobudy.api.entry_point.controller

import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import es.alejandrobudy.api.module.user.domain.User
import es.alejandrobudy.api.module.user.infrastructure.UserMarshaller._

object UserGetController {
  private val users = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  def apply(): StandardRoute = complete(users)
}
