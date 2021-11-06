package es.alejandrobudy.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object UserMarshaller extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply)
}
