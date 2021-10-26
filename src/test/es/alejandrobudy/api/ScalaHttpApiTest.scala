package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  private val body =
    """
      | {
      | "status": "ok"
      | }
      |""".stripMargin
  private val routesWithDefinedResponses =
    get {
      path("status") {
        complete(HttpEntity(ContentTypes.`application/json`, body))
      }
    }

  "ScalaHttpApi" should {
    "Respond successfully while request its status" in {
      Get("/status") ~> routesWithDefinedResponses ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe body
      }
    }
  }
}
