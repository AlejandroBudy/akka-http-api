package es.alejandrobudy.api.module.user.application

import es.alejandrobudy.api.module.user.domain.User

final class UserSearcher {
  private val users = Seq(
    User(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
    User(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
  )

  def all(): Seq[User] = users
}
