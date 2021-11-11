package es.alejandrobudy.api.entry_point

import es.alejandrobudy.api.entry_point.controller.UserGetController
import es.alejandrobudy.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntrypointDependencyContainer(
                                           userModuleDependencyController: UserModuleDependencyContainer
                                         ) {

  val userGetController: UserGetController = new UserGetController(userModuleDependencyController.userSearcher)
}
