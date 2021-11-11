package es.alejandrobudy.api.entry_point.controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import es.alejandrobudy.api.module.user.application.UserSearcher
import es.alejandrobudy.api.module.user.infrastructure.UserMarshaller._
import spray.json.DefaultJsonProtocol

final class UserGetController(searcher: UserSearcher) extends SprayJsonSupport with DefaultJsonProtocol {

  def apply(): StandardRoute = complete(searcher.all())
}
