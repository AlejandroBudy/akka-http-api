package es.alejandrobudy.api

import java.util.UUID

case class User(id: UserId, name: UserName)

object User {
  def apply(id: String, name: String) = new User(UserId(id), UserName(name))
}

case class UserId(id: UUID)

object UserId {
  def apply(id: String) = new UserId(UUID.fromString(id))
}

case class UserName(name: String)

object UserName {
  def apply(name: String) = new UserName(name)
}
