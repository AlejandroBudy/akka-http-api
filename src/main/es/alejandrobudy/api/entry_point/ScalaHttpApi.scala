package es.alejandrobudy.api.entry_point

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import es.alejandrobudy.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object ScalaHttpApi {
  def main(args: Array[String]): Unit = {
    val appConfig = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host = serverConfig.getString("http-server.host")
    val port = serverConfig.getInt("http-server.port")

    implicit val system: ActorSystem = ActorSystem(actorSystemName)
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val container = new EntrypointDependencyContainer(
      new UserModuleDependencyContainer
    )
    val routes = new Routes(container)

    val bindingFuture = Http().bindAndHandle(routes.all, host, port)

    //Run app until Enter is hit
    println(s"Server online at http://${host}:$port/\n Press RETURN to stop it")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
