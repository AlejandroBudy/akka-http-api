package es.alejandrobudy.api.module.user.infrastructure.dependency_injection

import es.alejandrobudy.api.module.user.application.UserSearcher

final class UserModuleDependencyContainer {
  val userSearcher = new UserSearcher
}
