package es.alejandrobudy.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object UserMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object UserNameMarshaller extends JsonFormat[UserName] {
    override def read(json: JsValue): UserName = json match {
      case JsString(name) => UserName(name)
      case _ => throw DeserializationException("Cant deserialize user name value")
    }

    override def write(obj: UserName): JsValue = JsString(obj.name)
  }

  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    override def read(json: JsValue): UserId = json match {
      case JsString(id) => UserId(id)
      case _ => throw DeserializationException("Cant deserialize user id value")
    }

    override def write(obj: UserId): JsValue = JsString(obj.id.toString)
  }

  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserName))
}
